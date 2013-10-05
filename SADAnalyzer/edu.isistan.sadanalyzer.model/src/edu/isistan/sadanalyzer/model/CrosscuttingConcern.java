/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

import SadModel.Sad;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Crosscutting Concern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getSads <em>Sads</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getCrosscuttingConcern()
 * @model
 * @generated
 */
public interface CrosscuttingConcern extends Identifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getCrosscuttingConcern_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Impacts</b></em>' reference list.
	 * The list contents are of type {@link edu.isistan.sadanalyzer.model.Impact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Impacts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Impacts</em>' reference list.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getCrosscuttingConcern_Impacts()
	 * @model
	 * @generated
	 */
	EList<Impact> getImpacts();

	/**
	 * Returns the value of the '<em><b>Sads</b></em>' reference list.
	 * The list contents are of type {@link SadModel.Sad}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sads</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sads</em>' reference list.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#getCrosscuttingConcern_Sads()
	 * @model
	 * @generated
	 */
	EList<Sad> getSads();

} // CrosscuttingConcern
