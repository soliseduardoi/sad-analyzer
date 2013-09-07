/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.sad;

import edu.isistan.uima.unified.typesystems.IdentifiableAnnotation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sad</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.Sad#getSections <em>Sections</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.Sad#getTemplatePath <em>Template Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad()
 * @model
 * @generated
 */
public interface Sad extends IdentifiableAnnotation {
	/**
	 * Returns the value of the '<em><b>Sections</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.uima.unified.typesystems.sad.SadSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' reference list.
	 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad_Sections()
	 * @model
	 * @generated
	 */
	EList<SadSection> getSections();

	/**
	 * Returns the value of the '<em><b>Template Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Path</em>' attribute.
	 * @see #setTemplatePath(String)
	 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad_TemplatePath()
	 * @model
	 * @generated
	 */
	String getTemplatePath();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getTemplatePath <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Path</em>' attribute.
	 * @see #getTemplatePath()
	 * @generated
	 */
	void setTemplatePath(String value);

} // Sad
