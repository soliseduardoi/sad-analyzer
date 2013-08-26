

/* First created by JCasGen Fri Mar 11 15:23:03 ART 2011 */
package edu.isistan.uima.unified.typesystems.sad;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;
import edu.isistan.uima.unified.typesystems.sad.Sad_Type;


/** 
 * Updated by JCasGen Wed Jun 20 16:11:03 ART 2012
 * XML source: G:/wsDisenio/wsSadProccesor/REAssistant/edu.isistan.uima.unified/desc/typesystems/ECoreTypeDescriptor.xml
 * @generated */
public class Sad extends IdentifiableAnnotation {
  /** @generated
   * @ordered 
   */
  public final static int typeIndexID = JCasRegistry.register(Sad.class);
  /** @generated
   * @ordered 
   */
  public final static int type = typeIndexID;
  /** @generated  */
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Sad() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Sad(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Sad(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Sad(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets 
   * @generated */
  public String getId() {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.sad.Sad");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sad_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets  
   * @generated */
  public void setId(String v) {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "edu.isistan.uima.unified.typesystems.sad.Sad");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sad_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: name

  /** getter for name - gets 
   * @generated */
  public String getName() {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.sad.Sad");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sad_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated */
  public void setName(String v) {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "edu.isistan.uima.unified.typesystems.sad.Sad");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sad_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: kind

  /** getter for kind - gets 
   * @generated */
  public String getKind() {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.sad.Sad");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Sad_Type)jcasType).casFeatCode_kind);}
    
  /** setter for kind - sets  
   * @generated */
  public void setKind(String v) {
    if (Sad_Type.featOkTst && ((Sad_Type)jcasType).casFeat_kind == null)
      jcasType.jcas.throwFeatMissing("kind", "edu.isistan.uima.unified.typesystems.sad.Sad");
    jcasType.ll_cas.ll_setStringValue(addr, ((Sad_Type)jcasType).casFeatCode_kind, v);}    
  }

    