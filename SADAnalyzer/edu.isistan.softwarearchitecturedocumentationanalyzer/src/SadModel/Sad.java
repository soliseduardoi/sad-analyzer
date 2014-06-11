/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sad</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link SadModel.Sad#getSections <em>Sections</em>}</li>
 *   <li>{@link SadModel.Sad#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link SadModel.Sad#getLocale <em>Locale</em>}</li>
 * </ul>
 * </p>
 *
 * @see SadModel.SadModelPackage#getSad()
 * @model
 * @generated
 */
public interface Sad extends Artifact {
	/**
	 * Returns the value of the '<em><b>Sections</b></em>' reference list.
	 * The list contents are of type {@link SadModel.SadSection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sections</em>' reference list.
	 * @see SadModel.SadModelPackage#getSad_Sections()
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
	 * @see SadModel.SadModelPackage#getSad_TemplatePath()
	 * @model
	 * @generated
	 */
	String getTemplatePath();

	/**
	 * Sets the value of the '{@link SadModel.Sad#getTemplatePath <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Path</em>' attribute.
	 * @see #getTemplatePath()
	 * @generated
	 */
	void setTemplatePath(String value);

	/**
	 * Returns the value of the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Locale</em>' attribute.
	 * @see #setLocale(String)
	 * @see SadModel.SadModelPackage#getSad_Locale()
	 * @model
	 * @generated
	 */
	String getLocale();

	/**
	 * Sets the value of the '{@link SadModel.Sad#getLocale <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locale</em>' attribute.
	 * @see #getLocale()
	 * @generated
	 */
	void setLocale(String value);
	

} // Sad
