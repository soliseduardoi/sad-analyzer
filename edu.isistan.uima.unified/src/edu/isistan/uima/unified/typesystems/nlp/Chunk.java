

/* First created by JCasGen Fri Mar 11 15:22:23 ART 2011 */
package edu.isistan.uima.unified.typesystems.nlp;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;


/** 
 * Updated by JCasGen Wed Jun 20 16:11:03 ART 2012
 * XML source: G:/wsDisenio/wsSadProccesor/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Chunk extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Chunk.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Chunk() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Chunk(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Chunk(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Chunk(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {}
     
 
    
  //*--------------*
  //* Feature: chunk

  /** getter for chunk - gets 
   * @generated */
  public String getChunk() {
    if (Chunk_Type.featOkTst && ((Chunk_Type)jcasType).casFeat_chunk == null)
      jcasType.jcas.throwFeatMissing("chunk", "edu.isistan.uima.unified.typesystems.nlp.Chunk");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Chunk_Type)jcasType).casFeatCode_chunk);}
    
  /** setter for chunk - sets  
   * @generated */
  public void setChunk(String v) {
    if (Chunk_Type.featOkTst && ((Chunk_Type)jcasType).casFeat_chunk == null)
      jcasType.jcas.throwFeatMissing("chunk", "edu.isistan.uima.unified.typesystems.nlp.Chunk");
    jcasType.ll_cas.ll_setStringValue(addr, ((Chunk_Type)jcasType).casFeatCode_chunk, v);}    
  }

    