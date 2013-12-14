// edge class
//
// provides the polygons for the QTM
//

import java.util.*;

public class TPolygon
{
	// components of a polygon

	// sub polygons
	private TPolygon _Poly1;
	private TPolygon _Poly2;
	private TPolygon _Poly3;
	private TPolygon _Poly4;

	// Edges
	private TEdge    _Edge1;
	private TEdge    _Edge2;
	private TEdge    _Edge3;


	// Constructor
	public TPolygon (TEdge Edge1, TEdge Edge2, TEdge Edge3)
	{
		// set up the polygon
		_Edge1 = Edge1;
		_Edge2 = Edge2;
		_Edge3 = Edge3;
      
		// null the sub polygons
		_Poly1 = null;
		_Poly2 = null;	
		_Poly3 = null;
		_Poly4 = null;
	}

	private boolean IsSubdivided()
	{
		if (_Poly1==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
     
	private void Subdivide()
	{
		// subdivide the edges
		_Edge1.Subdivide();
		_Edge2.Subdivide();          
		_Edge3.Subdivide();

		// get the sub edges
		TEdge E1 = _Edge1.Edge1();
		TEdge E2 = _Edge1.Edge2();
		TEdge E3 = _Edge2.Edge1();
		TEdge E4 = _Edge2.Edge2();
		TEdge E5 = _Edge3.Edge1();
		TEdge E6 = _Edge3.Edge2();

		// make the other three subedges 
		TEdge E7 = new TEdge(_Edge1.Edge1().BottomEnd(), _Edge2.Edge1().BottomEnd(), E1.Seed(), E1.SD());
		TEdge E8 = new TEdge(_Edge1.Edge1().BottomEnd(), _Edge3.Edge1().BottomEnd(), E1.Seed(), E1.SD());  
		TEdge E9 = new TEdge(_Edge2.Edge1().BottomEnd(), _Edge3.Edge1().BottomEnd(), E1.Seed(), E1.SD());

		// make the center polygon
		_Poly4 = new TPolygon(E7, E8, E9);

		// work out which way around the data is

		// get the six vertices
		TVector3d A1 = _Edge1.TopEnd().Position();
		TVector3d A2 = _Edge1.BottomEnd().Position();
		TVector3d B1 = _Edge2.TopEnd().Position();
		TVector3d B2 = _Edge2.BottomEnd().Position();
		TVector3d C1 = _Edge3.TopEnd().Position();
		TVector3d C2 = _Edge3.BottomEnd().Position(); 

		// now find out which order they go in
		if (A1.IsEqual(B1))
		{
			if (A2.IsEqual(C1))
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E3, E1);
				_Poly2 = new TPolygon(E5, E8, E2);
				_Poly3 = new TPolygon(E4, E9, E6);
			}
			else
			{
				// create polygon
				_Poly1= new TPolygon(E7, E3, E1);
				_Poly2= new TPolygon(E6, E8, E2);
				_Poly3= new TPolygon(E4, E9, E5);
			}
		}
		else if (A1.IsEqual(B2))
		{
			if (A2.IsEqual(C1))
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E4, E1);
				_Poly2 = new TPolygon(E5, E8, E2);
				_Poly3 = new TPolygon(E3, E9, E6);
			}
			else
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E4, E1);
				_Poly2 = new TPolygon(E6, E8, E2);
				_Poly3 = new TPolygon(E3, E9, E5);
			}
           
		}  
		else if (A2.IsEqual(B1))
		{
			if (A1.IsEqual(C1))
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E3, E2);
				_Poly2 = new TPolygon(E5, E8, E1);
				_Poly3 = new TPolygon(E4, E9, E6);
			}
			else
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E3, E2);
				_Poly2 = new TPolygon(E6, E8, E1);
				_Poly3 = new TPolygon(E4, E9, E5);
			}
		}
		else
		{
			if (A1.IsEqual(C1))
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E4, E2);
				_Poly2 = new TPolygon(E5, E8, E1);
				_Poly3 = new TPolygon(E3, E9, E6);
			}
			else
			{
				// create polygon
				_Poly1 = new TPolygon(E7, E4, E2);
				_Poly2 = new TPolygon(E6, E8, E1);
				_Poly3 = new TPolygon(E3, E9, E5);
			}        
		}
	}

	public void Generate(int Level,Vector Points)
	{   
		if (Level==0)
		{
			// use this level of the QTM

			// work out which way around the data is

			// get the six vertices
			TVector3d A1 = _Edge1.TopEnd().Position();
			TVector3d A2 = _Edge1.BottomEnd().Position();
			TVector3d B1 = _Edge2.TopEnd().Position();
			TVector3d B2 = _Edge2.BottomEnd().Position();

			// now find out which order they go in
         
			if (A1.IsEqual(B1))
			{
				// create polygon
				Points.addElement(A2);
				Points.addElement(A1);
				Points.addElement(B2);
			}
			else if (A1.IsEqual(B2))
			{
				// create polygon
				Points.addElement(A2);
				Points.addElement(A1);
				Points.addElement(B1);
			}  
			else if (A2.IsEqual(B1))
			{
				// create polygon
				Points.addElement(A1);
				Points.addElement(A2);
				Points.addElement(B2);
			}
			else
			{
				// create polygon
				Points.addElement(A1);
				Points.addElement(A2);
				Points.addElement(B1);
			}
		}
		else
		{
			// check to see if the polygon is subdivided 
			if (this.IsSubdivided()==false)
			{
				// subdivide the polygon
				this.Subdivide(); 
			}
 
			// call the child polygons
			_Poly1.Generate(Level - 1, Points);
			_Poly2.Generate(Level - 1, Points);
			_Poly3.Generate(Level - 1, Points);
			_Poly4.Generate(Level - 1, Points);
		}
	}
}