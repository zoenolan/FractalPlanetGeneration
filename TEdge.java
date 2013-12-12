// edge class
//
// provides the edges for the qtm polygons
//

import java.util.*;

public class TEdge
  {
   // components of a edge

   // sub edges
   private TEdge _Edge1;
   private TEdge _Edge2;

   // end points of edge
   private TVertex _TopEnd;
   private TVertex _BottomEnd;

   // random seed 
   private int _Seed ;
   
   // SD
   private float _SD;

   // constructor
   public TEdge (TVertex TopEnd, TVertex BottomEnd,int Seed,float SD)
     {
      // set end points
      _TopEnd=TopEnd;
      _BottomEnd=BottomEnd;
     
      // set seed and SD
      _Seed=Seed;
      _SD=SD;

      // set sub edge
      _Edge1=null ;
      _Edge2=null ;

     }

   // accessor
   public TEdge Edge1()
     {
      return _Edge1;
     }

   //accessor
   public TEdge Edge2()
     {
      return _Edge2;
     }

   // accessor
   public TVertex TopEnd()
     {
      return _TopEnd;
     }

   // accessor
   public TVertex BottomEnd()
     {
      return _BottomEnd;
     }

   // accessor
   public int Seed()
     {
      return _Seed;
     }

   //accessor
   public float SD()
     {
      return _SD;
     }

   // check to see if the edge is subdivided
   private boolean IsSubdivided()
     {
      if (_Edge1==null)
        {
         return false;
        }
      else
        {
         return true;
        }
     }

  // subdivide the edge
  public void Subdivide()
    {
     if (this.IsSubdivided()==false)
       {
        // work out mid point and displace it
        TVector3d MidPoint;
        int NewId;

        // work out the mid point
        MidPoint=new  TVector3d(_TopEnd.Position().X()+
                                   ((_BottomEnd.Position().X()-_TopEnd.Position().X())/2.0),
		             _TopEnd.Position().Y()+
                                   ((_BottomEnd.Position().Y()-_TopEnd.Position().Y())/2.0),
			     _TopEnd.Position().Z()+
                                   ((_BottomEnd.Position().Z()-_TopEnd.Position().Z())/2.0));

        // work out the new id value
        NewId=6-(_TopEnd.Id()+_BottomEnd.Id());


        // work out the displacement
        Random randomNumGenerator = new Random(_Seed*NewId);
        float temp=randomNumGenerator.nextFloat() ;
        temp=(float)(temp*(_SD/2.0));

        // work out displacement
        MidPoint.FixLength((float)((_TopEnd.Position().Length()+_TopEnd.Position().Length())/2.0
                           +temp )) ;

        // make the new Vertex
        TVertex NewVertex=new TVertex(MidPoint,NewId) ;

        // do the sub division     
        _Edge1=new TEdge (_TopEnd,NewVertex,_Seed,(float)(_SD/2.0));
        _Edge2=new TEdge (NewVertex,_BottomEnd,_Seed,(float)(_SD/2.0));

       }
     }
}












