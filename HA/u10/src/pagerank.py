# -*- encoding: utf-8 -*-

from matrix import Matrix
from graph import Graph

def get_mod_addj_matrix(graph):
    """ Erstellt eine modifizierte Adjazenzmatrix aus einem Graphen
    """
    out_deg = [sum(map(lambda(x,y): 1 if v == x else 0, graph.edges)) \
            for v in graph.vertices] # bestimme Ausgrad aller Knoten
    mod_addj_matrix = Matrix.zero(len(graph.vertices))
                               # erstelle Nullmatrix

    # setze Werte in erstellter Nullmatrix für modifizierte Adjazenzmatrix
    for i,v_i in enumerate(graph.vertices):
        for j,v_j in enumerate(graph.vertices):
            if (v_i,v_j) in graph.edges:
                mod_addj_matrix[i][j] = 1.0/out_deg[i]

    return mod_addj_matrix

def pagerank(graph, d = 0.25, error = 0.001):
    N = len(graph.vertices)
    Pi = Matrix([[1.0/N for n in range(N)]])
    A1 = get_mod_addj_matrix(graph)
    A2 = A1.scalar_mul(1-d) + Matrix.one(A1.height,A1.width).scalar_mul(d/N)
    iterations = 1
    Pi_new = Pi * A2

    while (Pi_new-Pi).max_norm() >= error:
        Pi = Pi_new
        Pi_new = Pi * A2
        iterations += 1
        
    return Pi_new, iterations 

G = Graph(['a','b','c','d'],[('a','b'),('b','c'),('b','d'),('c','a'),('d','c')])
print "Modified adjacency matrix:", get_mod_addj_matrix(G)
p,it = pagerank(G)
print "Number of iterations for page rank:", it
