/*
 * File: $Id: DiGraph.java,v 1.2 2009/03/26 01:53:56 vcss23x Exp $
 * Revisions:
 *      $Log: DiGraph.java,v $
 *      Revision 1.2  2009/03/26 01:53:56  vcss23x
 *      formatting
 *
 *      Revision 1.1  2008/03/25 14:51:58  vcss23x
 *      Initial revision
 *
 */
import java.util.Collection;

/**
 * An interface for a directed graph.  Every vertex in the graph is
 * identified by a unique key.  Data can be stored at each edge and
 * vertex in the graph.
 *
 * @author Paul Tymann (ptt@cs.rit.edu)
 * @author James Heliotis (jeh@cs.rit.edu)
 */

public interface DiGraph< VKeyT, VDataT, EDataT > {

    // Methods to build the graph

    /**
     * Add a vertex to the graph.  If the graph already contains a vertex
     * with the given key the old data will be replaced by the new data.
     *
     * @param key the key that identifies the vertex.
     * @param data the data to be associated with the vertex.
     */

    public void addVertex( VKeyT key, VDataT data );

    /**
     * Add an edge to the graph starting at the vertex identified by
     * fromKey and ending at the vertex identified by toKey.  If either of
     * the vertices do not exist a NoSuchVertexException will be thrown.
     * If the graph already contains this edge, the old data will be replaced
     * by the new data.
     *
     * @param fromKey the key associated with the starting vertex of the edge.
     * @param toKey the key associated with the ending vertex of the edge.
     * @param data the data to be associated with the edge.
     *
     * @exception NoSuchVertexException if either end point is not a
     *            key associated with a vertex in the graph.
     */

    public void addEdge( VKeyT fromKey, VKeyT toKey, EDataT data )
        throws NoSuchVertexException;

    // Operations on edges

    /**
     * Return true if the edge defined by the given vertices is an
     * edge in the graph.  False will be returned if the edge is not
     * in the graph.  A NoSuchVertexException will be thrown if either
     * of the vertices do not exist.
     *
     * @param fromKey the key of the vetex where the edge starts.
     * @param toKey the key of the vertex where the edge ends.
     *
     * @return true if the edge defined by the given vertices is in
     *         the graph and false otherwise.
     *
     * @exception NoSuchVertexException if either end point is not a
     *            key associated with a vertex in the graph.
     */

    public boolean isEdge( VKeyT fromKey, VKeyT toKey )
        throws NoSuchVertexException;

    /**
     * Return a reference to the data associated with the edge that is 
     * defined by the given end points.  Null will be returned if the 
     * edge is not in the graph.  Note that a return value of null does
     * not necessarily imply that the edge is not in the graph.  It may
     * be the case that the data associated with the edge is null.  A 
     * NoSuchVertexException will be thrown if either of the end points 
     * do not exist.
     *
     * @param fromKey the key of the vertex where the edge starts.
     * @param toKey the key of the vertex where the edge ends.
     *
     * @return a reference to the data associated with the edge defined by
     *         the specified end points.  Null is returned if the edge 
     *         is not in the graph.
     *
     * @exception NoSuchVertexException if either end point is not a
     *            key associated with a vertex in the graph.
     */

    public EDataT getEdgeData( VKeyT fromKey, VKeyT toKey )
        throws NoSuchVertexException;

    // Operations on vertices

    /**
     * Returns true if the graph contains a vertex with the associated
     * key.
     *
     * @param key the key of the vertex being looked for.
     *
     * @return true if the key is associated with a vertex in the graph
     *         and false otherwise.
     */

    public boolean isVertex( VKeyT key );

    /**
     * Return a reference to the data associated with the vertex 
     * identified by the key.  A NoSuchVertexException will be thrown
     * if the key is not associated with a vertex in the graph.
     *
     * @param key the key of the vertex being looked for.
     *
     * @return the data associated with the vertex that is identifed by the
     *         key.
     *
     * @exception NoSuchVertexException if the key is not associated
     *            with a vertex in the graph.
     */

    public VDataT getVertexData( VKeyT key ) throws NoSuchVertexException;

    /**
     * Returns a count of the number of vertices in the graph.
     *
     * @return   the count of the number of vertices in this graph
     */

    public int numVertices();

    /**
     * Return the in degree of the vertex that is associated with the
     * given key.  Negative 1 is returned if the vertex cannot be found.
     *
     * @param key the key of the vertex being looked for.
     *
     * @return the in degree of the vertex associated with the key or
     *         -1 if the vertex is not in the graph.
     */

    public int inDegree( VKeyT key );

    /**
     * Return the out degree of the vertex that is associated with the
     * given key.  Negative 1 is returned if the vertex cannot be found.
     *
     * @param key the key of the vertex being looked for.
     *
     * @return the out degree of the vertex associated with the key or
     *         -1 if the vertex is not in the graph.
     */

    public int outDegree( VKeyT key );

    /**
     * Returns a collection containing the data associated with the
     * neighbors of the vertex identified by the specified key.
     * The collection will be empty if there are no neighbors.  A
     * NoSuchVertexException will be thrown if the key is not associated
     * with a vertex in the graph.
     *
     * @param key the key associated with the vertex whose neighbors we
     *        wish to obtain.
     *
     * @return a collection containing the data associated with the neighbors
     *         of the vertex with the given key.  The collection will be
     *         empty if the vertex does not have any neighbors.
     *
     * @exception NoSuchVertexException if the key is not associated
     *            with a vertex in the graph.
     */

    public Collection< VDataT > neighborData( VKeyT key )
                                         throws NoSuchVertexException;

    /**
     * Returns a collection containing the keys associated with the
     * neighbors of the vertex identified by the specified key.
     * The collection will be empty if there are no neighbors.  A
     * NoSuchVertexException will be thrown if the key is not associated
     * with a vertex in the graph.
     *
     * @param key the key associated with the vertex whose neighbors we
     *        wish to obtain.
     *
     * @return a collection containing the keys associated with the neighbors
     *         of the vertex with the given key.  The collection will be
     *         empty if the vertex does not have any neighbors.
     *
     * @exception NoSuchVertexException if the key is not associated with
     *            a vertex in the graph.
     */

    public Collection< VKeyT > neighborKeys( VKeyT key )
                                         throws NoSuchVertexException;

    // Utility

    /**
     * Returns a collection containing the data associated with all of
     * the vertices in the graph.
     *
     * @return a collection containing the data associated with the
     *         vertices in the graph.
     */

    public Collection< VDataT > vertexData();

    /**
     * Returns a collection containing the keys associated with all of
     * the vertices in the graph.
     *
     * @return a collection containing the keys associated with the
     *         vertices in the graph.
     */

    public Collection< VKeyT > vertexKeys();

    /**
     * Return a collection containing all of the data associated with the
     * edges in the graph.
     *
     * @return a collection containing the data associated with the edges
     *         in this graph.
     */
    
    public Collection< EDataT > edgeData();

    /**
     * Remove all vertices and edges from the graph.
     */

    public void clear();

} // DiGraph
