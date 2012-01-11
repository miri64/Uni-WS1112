class Matrix(object):
    def __init__(self, array):
        row_length = len(array[0])
        for a in array:
            if row_length != len(a):
                raise ValueError('Rows are not equaly long')
        self._array = array
    
    def __repr__(self):
        return repr(self._array)
    
    def __str__(self):
        return repr(self)
    
    def __len__(self):
        return len(self._array)
    
    def __getitem__(self,key):
        return self._array[key]
    
    def __getattr__(self,attr):
        if attr == 'width':
            return self.__width()
        elif attr == 'height':
            return self.__height()

    @staticmethod
    def zero(i,j=None):
        if j == None: j = i
        return Matrix([[0 for x in range(j)] for y in range(i)])
    
    @staticmethod
    def one(i,j=None):
        if j == None: j = i
        return Matrix([[1 for x in range(j)] for y in range(i)])
    
    def __width(self):
        return len(self[0])
    
    def __height(self):
        return len(self)
    
    def __mul__(self,m):
        if self.width != m.height:
            raise ValueError("Wrong dimensions (%d,%d) for Multiplication",self.width,m.height)
        result = Matrix.zero(self.height,m.width)
        for i in range(self.height):
            for j in range(m.width):
                for k in range(m.height):
                    result[i][j] += self[i][k] * m[k][j]
        return result
    
    def __add__(self,m):
        if self.width != m.width or self.height != m.height:
            raise ValueError('Matrices must have same dimensions.')
        result = Matrix.zero(self.height,self.width)
        for i in range(self.height):
            for j in range(self.width):
                result[i][j] = self[i][j] + m[i][j]
        return result
    
    def __sub__(self,m):
        if self.width != m.width or self.height != m.height:
            raise ValueError('Matrices must have same dimensions.')
        result = Matrix.zero(self.height,self.width)
        for i in range(self.height):
            for j in range(self.width):
                result[i][j] = self[i][j] - m[i][j]
        return result
    
    def max_norm(self):
        return max([max([abs(x) for x in row]) for row in self._array])
    
    def scalar_mul(self, scalar):
        result = Matrix.zero(self.height,self.width)
        for i in range(self.height):
            for j in range(self.width):
                result[i][j] = scalar * self[i][j]
        return result
