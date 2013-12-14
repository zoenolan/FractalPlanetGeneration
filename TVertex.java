//
// vertex class
//
// provides the nodes for the QTM edges
//

public class TVertex
{
	// components of a vertex
	private TVector3d	_Position;
	private int 	    _Id;

	public TVertex (TVector3d Position, int Id)
	{
		_Position = Position;
		_Id = Id;
	}

	public TVector3d Position()
	{
		return _Position;
	}

	public int Id()
	{
		return _Id;
	}
}