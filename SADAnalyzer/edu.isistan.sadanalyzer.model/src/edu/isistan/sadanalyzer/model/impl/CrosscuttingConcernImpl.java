/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import SadModel.Sad;

import edu.isistan.sadanalyzer.model.CrosscuttingConcern;
import edu.isistan.sadanalyzer.model.Impact;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Crosscutting Concern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl#getSads <em>Sads</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CrosscuttingConcernImpl extends IdentifiableImpl implements CrosscuttingConcern {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImpacts() <em>Impacts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImpacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Impact> impacts;

	/**
	 * The cached value of the '{@link #getSads() <em>Sads</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSads()
	 * @generated
	 * @ordered
	 */
	protected EList<Sad> sads;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CrosscuttingConcernImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SadAnalyzerModelPackage.Literals.CROSSCUTTING_CONCERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Impact> getImpacts() {
		if (impacts == null) {
			impacts = new EObjectResolvingEList<Impact>(Impact.class, this, SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__IMPACTS);
		}
		return impacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sad> getSads() {
		if (sads == null) {
			sads = new EObjectResolvingEList<Sad>(Sad.class, this, SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__SADS);
		}
		return sads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				return getDescription();
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				return getImpacts();
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__SADS:
				return getSads();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				getImpacts().clear();
				getImpacts().addAll((Collection<? extends Impact>)newValue);
				return;
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__SADS:
				getSads().clear();
				getSads().addAll((Collection<? extends Sad>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				getImpacts().clear();
				return;
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__SADS:
				getSads().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__IMPACTS:
				return impacts != null && !impacts.isEmpty();
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN__SADS:
				return sads != null && !sads.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //CrosscuttingConcernImpl
