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
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.Sad#getId <em>Id</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.Sad#getKind <em>Kind</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.Sad#getName <em>Name</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad_Kind()
	 * @model
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.isistan.uima.unified.typesystems.sad.SadPackage#getSad_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Sad
