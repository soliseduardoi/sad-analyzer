/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

import SadModel.Sad;
import SadModel.SadSection;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.Impact#getRealization <em>Realization</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.Impact#getSection <em>Section</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.Impact#getSad <em>Sad</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.Impact#getSentence <em>Sentence</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.Impact#getCompositionRules <em>Composition Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact()
 * @model
 * @generated
 */
public interface Impact extends Identifiable {
	/**
	 * Returns the value of the '<em><b>Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Realization</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realization</em>' attribute.
	 * @see #setRealization(String)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact_Realization()
	 * @model
	 * @generated
	 */
	String getRealization();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.Impact#getRealization <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Realization</em>' attribute.
	 * @see #getRealization()
	 * @generated
	 */
	void setRealization(String value);

	/**
	 * Returns the value of the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Section</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Section</em>' reference.
	 * @see #setSection(SadSection)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact_Section()
	 * @model
	 * @generated
	 */
	SadSection getSection();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.Impact#getSection <em>Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Section</em>' reference.
	 * @see #getSection()
	 * @generated
	 */
	void setSection(SadSection value);

	/**
	 * Returns the value of the '<em><b>Sad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sad</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sad</em>' reference.
	 * @see #setSad(Sad)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact_Sad()
	 * @model
	 * @generated
	 */
	Sad getSad();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.Impact#getSad <em>Sad</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sad</em>' reference.
	 * @see #getSad()
	 * @generated
	 */
	void setSad(Sad value);

	/**
	 * Returns the value of the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sentence</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sentence</em>' reference.
	 * @see #setSentence(Sentence)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact_Sentence()
	 * @model
	 * @generated
	 */
	Sentence getSentence();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.Impact#getSentence <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sentence</em>' reference.
	 * @see #getSentence()
	 * @generated
	 */
	void setSentence(Sentence value);

	/**
	 * Returns the value of the '<em><b>Composition Rules</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.isistan.sadanalyzer.model.CompositionRules}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composition Rules</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composition Rules</em>' attribute.
	 * @see edu.isistan.sadanalyzer.model.CompositionRules
	 * @see #setCompositionRules(CompositionRules)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getImpact_CompositionRules()
	 * @model
	 * @generated
	 */
	CompositionRules getCompositionRules();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.Impact#getCompositionRules <em>Composition Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composition Rules</em>' attribute.
	 * @see edu.isistan.sadanalyzer.model.CompositionRules
	 * @see #getCompositionRules()
	 * @generated
	 */
	void setCompositionRules(CompositionRules value);

} // Impact
