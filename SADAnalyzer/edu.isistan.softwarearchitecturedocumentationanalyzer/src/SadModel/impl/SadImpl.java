/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel.impl;

import SadModel.Sad;
import SadModel.SadModelPackage;
import SadModel.SadSection;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sad</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link SadModel.impl.SadImpl#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SadImpl extends ArtifactImpl implements Sad {
	/**
	 * The cached value of the '{@link #getSections() <em>Sections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSections()
	 * @generated
	 * @ordered
	 */
	protected EList<SadSection> sections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SadModelPackage.Literals.SAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SadSection> getSections() {
		if (sections == null) {
			sections = new EObjectResolvingEList<SadSection>(SadSection.class, this, SadModelPackage.SAD__SECTIONS);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SadModelPackage.SAD__SECTIONS:
				return getSections();
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
			case SadModelPackage.SAD__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends SadSection>)newValue);
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
			case SadModelPackage.SAD__SECTIONS:
				getSections().clear();
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
			case SadModelPackage.SAD__SECTIONS:
				return sections != null && !sections.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SadImpl
