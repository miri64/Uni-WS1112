package main;

import java.io.*;
import java.util.*;


public class Klammerung {
	
	static class Entry {
		Entry() {};
		int value;
		int index;
	}

	static int naiv( List< Integer > dimensions )
	{
		int value = 0;
		for( int i = 1; i < dimensions.size() - 1; i++ )
		{
			value += dimensions.get( 0 ) * dimensions.get( i + 1 ) * ( 2 * dimensions.get( i ) - 1 );
		}
		
		return value;
	}
	
	static List< ArrayList< Entry > > optimiert( List< Integer > dimensions )
	{
		List< ArrayList< Entry > > kosten = new ArrayList< ArrayList< Entry > >();
		for( int i = 0; i < dimensions.size() - 1; i++ )
		{
			ArrayList< Entry > tmp = new ArrayList< Entry >();
			for( int j = 0; j < dimensions.size() - 1; j++ )
			{
				Entry e = new Entry();
				e.value = 0;
				e.index = 0;
				tmp.add( e );
			}
			kosten.add( tmp );
		}
		
		for( int k = 1; k < dimensions.size() - 1; k++ )
		{
			for( int i = 0; i < dimensions.size() - 1 - k; i++ )
			{
				int minValue = Integer.MAX_VALUE;
				int minIndex = 0;
				int j = i + k;
				for( int t = 1; t <= k; t++ )
				{
					int val = kosten.get( i ).get( j - t ).value
							+ kosten.get( i + k + 1 - t ).get( j ).value
							+ ( dimensions.get( i )
								* dimensions.get( j + 1 )
								* ( 2 * dimensions.get( j - t + 1 ) - 1 ) );
					//System.out.println( "k="+k+"\ti="+i+"\tj="+j+"\tt="+t+"\tval="+val);
					if( val < minValue )
					{
						minValue = val;
						minIndex = j - t + 1;
					}
				}
				kosten.get( i ).get( j ).value = minValue;
				kosten.get( i ).get( j ).index = minIndex;
			}
		}
		return kosten;
	}
	
	static void printMatrix( List< ArrayList< Entry > > matrix )
	{
		for( int j = 0; j < matrix.get( 0 ).size(); j++ )
		{
			for( int i = 0; i < matrix.size(); i++ )
			{
				System.out.print( matrix.get( i ).get( j ).value /*+ "|" + matrix.get( i ).get( j ).index*/ + "\t" );
			}
			System.out.println();
		}
	}
	
	static String klammerung( List< Integer > dimensions, List< ArrayList< Entry > > matrix, int i, int j )
	{
		if( matrix.get( i ).get( j ).index == 0 )
			return "M_" + i /*+ "(" + dimensions.get( i ) + "x" + dimensions.get( i + 1 ) + ")"*/;
		return "(" + klammerung( dimensions, matrix, i, matrix.get( i ).get( j ).index - 1 ) + " * "
				+ klammerung( dimensions, matrix, matrix.get( i ).get( j ).index, j ) + ")";
	}
	
	public static void main( String[] args )
	{
		System.out.println( "Programm zur Berechnung von Operationsschritten von Matrizenkettenmultiplikation\n" );
		System.out.println( "Geben sie ihre Matrizendimensionen an (\"a b c\" für zwei Matrizen a x b und b x c): " );

		InputStreamReader inputStreamReader = new InputStreamReader( System.in );
		BufferedReader bufferedReader = new BufferedReader( inputStreamReader );
		String input = "";
		try
		{
			input = bufferedReader.readLine();
		}
		catch( Exception e ) {}
		String[] dimensionsStrings = input.split( " " );
		List< Integer > dimensions = new ArrayList< Integer >();
		for( int i = 0; i < dimensionsStrings.length; i++ )
		{
			dimensions.add( Integer.parseInt( dimensionsStrings[ i ] ) );
		}
		for( int i = 0; i < dimensions.size() - 1; i++ )
		{
			System.out.println( "M_" + i + "(" + dimensions.get( i ) + "x" + dimensions.get( i + 1 ) + ")" );
		}
		
		// Berechne #Rechenoperationen des optimierten Algorithmus
		List< ArrayList< Entry > > kosten = optimiert( dimensions );
		System.out.println( "\nMatrix:");
		printMatrix( kosten );
		System.out.println();
		
		// Berechne #Rechenoperationen des naiven Algorithmus und gib aus
		System.out.println( "\nDer naive Ansatz benötigt " + naiv( dimensions ) + " Rechenoperationen." );
		
		// Gib die optimalen Ergebnisse aus
		System.out.println( "\nDer optimierte Algorithmus benötigt " + kosten.get( 0 ).get( kosten.size() - 1 ).value + " Rechenoperationen." );
		System.out.println( "Die optimale Klammerung ist: " + klammerung( dimensions, kosten, 0, kosten.size() - 1 ) );
	}
}