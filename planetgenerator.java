import java.util.* ;

public class planetgenerator
{
 public static void main(String[] args)
   {
    // number of triangles in the mesh.
    int NumberOfTriangles ;

    // loop counter for writing out the triangle data
    int LoopCounter ;

    // planet object 
    TQtm Planet=new TQtm(342432,0.35f);

    // output fields
    Vector Points=new Vector(0) ;

    // create the mesh

    Planet.Generate(4,Points) ;

    // work out the number of triangles
    NumberOfTriangles=(Points.size())/3 ;

    
    // print out the header
    System.out.println("#VRML V2.0 utf8") ;

    // make the sky black
    System.out.println("Background");
    System.out.println("{");
    System.out.println("skyColor [0.0 0.0 0.01]");
    System.out.println("skyAngle [0.0]");
    System.out.println("}");

    // add a light
    System.out.println("PointLight");
    System.out.println("{");
    System.out.println("on TRUE");
    System.out.println("location -5.0 10.0 -10.0");
    System.out.println("radius 2.0");
    System.out.println("intensity 1.0");
    System.out.println("ambientIntensity 0.0");
    System.out.println("color 1.0 1.0 1.0");
    System.out.println("attenuation 1.0 0.0 0.0");
    System.out.println("}");




    // planet data
    System.out.println("Shape");
    System.out.println("{");
    System.out.println("appearance Appearance");
    System.out.println("{");
    System.out.println("material Material");
    System.out.println("{");
    System.out.println("}");
    System.out.println("}");
    System.out.println("geometry IndexedFaceSet");
    System.out.println("{");
    System.out.println("coord Coordinate");
    System.out.println("{");
    System.out.println("point");
    System.out.println("[");

    // dump out vector data
    for (LoopCounter=0;LoopCounter<NumberOfTriangles;LoopCounter++)
      {
       // write out one set of three vectors for a triangle.

       // get the first vector
       TVector3d temp=(TVector3d)Points.elementAt((LoopCounter*3)) ;
       System.out.println(temp.X()+" "+temp.Y()+" "+temp.Z()+",");

       // get the second vector
       temp=(TVector3d)Points.elementAt((LoopCounter*3)+1) ;
       System.out.println(temp.X()+" "+temp.Y()+" "+temp.Z()+",");

       // get the third vector
       temp=(TVector3d)Points.elementAt((LoopCounter*3)+2) ;
       System.out.println(temp.X()+" "+temp.Y()+" "+temp.Z()+",");
      }

    // more text
    System.out.println("]");
    System.out.println("}");
    System.out.println("coordIndex");
    System.out.println("[");

    // dump order data
    for (LoopCounter=0;LoopCounter<NumberOfTriangles;LoopCounter++)
      {
       // write out one set of three vectors for a triangle.
       System.out.println((LoopCounter*3)+","+
			  ((LoopCounter*3)+1)+","+
                          ((LoopCounter*3)+2)+",-1,");
      }

    // more text
    System.out.println("]");
    System.out.println("color Color");
    System.out.println("{");
    System.out.println("color");
    System.out.println("[");

    // set colour
    System.out.println("0.6 0.6 0.7");

    // more text
    System.out.println("]") ;
    System.out.println("}") ;
    System.out.println("colorIndex");
    System.out.println("[");

    // loop for number of polygons
    for (LoopCounter=0;LoopCounter<(NumberOfTriangles-1);LoopCounter++)
      {
       // write out one set of three vectors for a triangle.
       System.out.println("0,");
      }

    System.out.println("0");

    // more text
    System.out.println("]");
    System.out.println("colorPerVertex FALSE");
    System.out.println("convex TRUE");
    System.out.println("solid FALSE");
    System.out.println("ccw FALSE");
    System.out.println("creaseAngle 180.0");
    System.out.println("}");
    
   }
}
