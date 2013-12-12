// vector class

// provides 3d vectors to Vertex

public class TVector3d
  {
   // components of the vector
   private float _X ;
   private float _Y ;
   private float _Z ;

   // constuctor
   public TVector3d (double X,double Y,double Z)
     {
      _X=(float)X ;
      _Y=(float)Y ;
      _Z=(float)Z ;
     }

   // constuctor
   public TVector3d (float X,float Y,float Z)
     {
      _X=X ;
      _Y=Y ;
      _Z=Z ;
     }

   // selectors
   public float X()
     {
      return _X ;
     }

   public float Y()
     {
      return _Y ;
     }

   public float Z()
     {
      return _Z ;
     }
 
   // operations

   // length
   public float Length()
     {
      return (float)(Math.sqrt((_X*_X)+(_Y*_Y)+(_Z*_Z))) ;
     } 

   // unit
   public void Unit()
     {
      float Length=this.Length() ;

      _X=_X/Length ;
      _Y=_Y/Length ;
      _Z=_Z/Length ;
     }


   // fix length
   public void FixLength(float Length)
     {
      this.Unit() ;

      _X=_X*Length ;
      _Y=_Y*Length ;
      _Z=_Z*Length ;
     }

  // Is Equal
   public boolean IsEqual(TVector3d B)
     {
      if ( (_X==B.X()) && (_Y==B.Y()) && (_Z==B.Z()) )
        {
         return true ;
        }
      else
        {
         return false ;
        }
     }
  }



















