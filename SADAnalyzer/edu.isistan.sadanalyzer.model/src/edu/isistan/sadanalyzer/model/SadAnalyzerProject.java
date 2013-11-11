/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

import SadModel.Artifact;
import SadModel.Sad;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sad Analyzer Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSad <em>Sad</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSadURI <em>Sad URI</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getUimaURI <em>Uima URI</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getSadAnalyzerProject()
 * @model
 * @generated
 */
public interface SadAnalyzerProject extends Identifiable, Nameable {
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
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getSadAnalyzerProject_Sad()
	 * @model
	 * @generated
	 */
	Sad getSad();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSad <em>Sad</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sad</em>' reference.
	 * @see #getSad()
	 * @generated
	 */
	void setSad(Sad value);

	/**
	 * Returns the value of the '<em><b>Sad URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sad URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sad URI</em>' attribute.
	 * @see #setSadURI(String)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getSadAnalyzerProject_SadURI()
	 * @model
	 * @generated
	 */
	String getSadURI();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSadURI <em>Sad URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sad URI</em>' attribute.
	 * @see #getSadURI()
	 * @generated
	 */
	void setSadURI(String value);

	/**
	 * Returns the value of the '<em><b>Uima URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uima URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uima URI</em>' attribute.
	 * @see #setUimaURI(String)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getSadAnalyzerProject_UimaURI()
	 * @model
	 * @generated
	 */
	String getUimaURI();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getUimaURI <em>Uima URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uima URI</em>' attribute.
	 * @see #getUimaURI()
	 * @generated
	 */
	void setUimaURI(String value);

	/**
	 * Returns the value of the '<em><b>Crosscutting Concerns</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.sadanalyzer.model.CrosscuttingConcern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Crosscutting Concerns</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Crosscutting Concerns</em>' reference list.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getSadAnalyzerProject_CrosscuttingConcerns()
	 * @model
	 * @generated
	 */
	EList<CrosscuttingConcern> getCrosscuttingConcerns();

} // SadAnalyzerProject
