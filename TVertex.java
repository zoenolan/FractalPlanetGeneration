// vertex class
//
// provides the nodes for the QTM edges
//

public class TVertex
  {
   // components of a vertex
   private TVector3d 	_Position ;
   private int 	     	_Id ;

   // constuctor
   public TVertex (TVector3d Position,int Id)
     {
      _Position=Position;
      _Id=Id;

     }

   // accessor
   public TVector3d Position()
     {
      return _Position;
     }

   // accessor
   public int Id()
     {
      return _Id ;
     }
  }
 


















