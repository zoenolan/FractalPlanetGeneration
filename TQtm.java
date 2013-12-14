// main qtm class

import java.util.*;

public class TQtm
{
	// the eight polygons of base object
	TPolygon _A;
	TPolygon _B;
	TPolygon _C;
	TPolygon _D;
	TPolygon _E;
	TPolygon _F;
	TPolygon _G;
	TPolygon _H;

	int      _Seed;
	float    _SD;

	//
	// methods
	//

	// set up the QTM
	public TQtm(int Seed, float SD)
	{
		// create random number

		// create the six vertices
		TVertex Vertex1 = new TVertex(new TVector3d( 1.0f,  0.0f,  0.0f), 1);
		TVertex Vertex2 = new TVertex(new TVector3d(-1.0f,  0.0f,  0.0f), 1);
		TVertex Vertex3 = new TVertex(new TVector3d( 0.0f,  1.0f,  0.0f), 2);
		TVertex Vertex4 = new TVertex(new TVector3d( 0.0f, -1.0f,  0.0f), 2);
		TVertex Vertex5 = new TVertex(new TVector3d( 0.0f,  0.0f,  1.0f), 3);
		TVertex Vertex6 = new TVertex(new TVector3d( 0.0f,  0.0f, -1.0f), 3);
 
		// create the 12 edges
		TEdge Edge1  = new TEdge(Vertex1, Vertex3, Seed, (float)(SD / 2.0));
		TEdge Edge2  = new TEdge(Vertex1, Vertex4, Seed, (float)(SD / 2.0));     
		TEdge Edge3  = new TEdge(Vertex1, Vertex5, Seed, (float)(SD / 2.0));
		TEdge Edge4  = new TEdge(Vertex1, Vertex6, Seed, (float)(SD / 2.0));
		TEdge Edge5  = new TEdge(Vertex2, Vertex3, Seed, (float)(SD / 2.0));
		TEdge Edge6  = new TEdge(Vertex2, Vertex4, Seed, (float)(SD / 2.0));
		TEdge Edge7  = new TEdge(Vertex2, Vertex5, Seed, (float)(SD / 2.0));
		TEdge Edge8  = new TEdge(Vertex2, Vertex6, Seed, (float)(SD / 2.0));
		TEdge Edge9  = new TEdge(Vertex3, Vertex5, Seed, (float)(SD / 2.0));
		TEdge Edge10 = new TEdge(Vertex3, Vertex6, Seed, (float)(SD / 2.0));
		TEdge Edge11 = new TEdge(Vertex4, Vertex5, Seed, (float)(SD / 2.0));
		TEdge Edge12 = new TEdge(Vertex4, Vertex6, Seed, (float)(SD / 2.0));

		// create the 8 polygons
		_A = new TPolygon(Edge1,  Edge3,  Edge9);     
		_B = new TPolygon(Edge11, Edge3,  Edge2); 
		_C = new TPolygon(Edge6,  Edge7,  Edge11); 
		_D = new TPolygon(Edge9,  Edge7,  Edge5); 
		_E = new TPolygon(Edge4,  Edge10, Edge1); 
		_F = new TPolygon(Edge5,  Edge8,  Edge10); 
		_G = new TPolygon(Edge12, Edge8,  Edge6); 
		_H = new TPolygon(Edge12, Edge2,  Edge4); 
	}

	// generate a mesh
	public void Generate(int Level,Vector Points)
	{
		_A.Generate(Level, Points) ;
		_B.Generate(Level, Points) ;
		_C.Generate(Level, Points) ;
		_D.Generate(Level, Points) ;
		_E.Generate(Level, Points) ;
		_F.Generate(Level, Points) ;
		_G.Generate(Level, Points) ;
		_H.Generate(Level, Points) ;
	}
}