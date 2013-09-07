/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.sad.impl;

import edu.isistan.uima.unified.typesystems.impl.IdentifiableAnnotationImpl;

import edu.isistan.uima.unified.typesystems.sad.Sad;
import edu.isistan.uima.unified.typesystems.sad.SadPackage;
import edu.isistan.uima.unified.typesystems.sad.SadSection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sad</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl#getTemplatePath <em>Template Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SadImpl extends IdentifiableAnnotationImpl implements Sad {
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
	 * The default value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplatePath()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPLATE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplatePath() <em>Template Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTemplatePath()
	 * @generated
	 * @ordered
	 */
	protected String templatePath = TEMPLATE_PATH_EDEFAULT;

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
		return SadPackage.Literals.SAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SadSection> getSections() {
		if (sections == null) {
			sections = new EObjectResolvingEList<SadSection>(SadSection.class, this, SadPackage.SAD__SECTIONS);
		}
		return sections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTemplatePath() {
		return templatePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTemplatePath(String newTemplatePath) {
		String oldTemplatePath = templatePath;
		templatePath = newTemplatePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadPackage.SAD__TEMPLATE_PATH, oldTemplatePath, templatePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SadPackage.SAD__SECTIONS:
				return getSections();
			case SadPackage.SAD__TEMPLATE_PATH:
				return getTemplatePath();
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
			case SadPackage.SAD__SECTIONS:
				getSections().clear();
				getSections().addAll((Collection<? extends SadSection>)newValue);
				return;
			case SadPackage.SAD__TEMPLATE_PATH:
				setTemplatePath((String)newValue);
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
			case SadPackage.SAD__SECTIONS:
				getSections().clear();
				return;
			case SadPackage.SAD__TEMPLATE_PATH:
				setTemplatePath(TEMPLATE_PATH_EDEFAULT);
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
			case SadPackage.SAD__SECTIONS:
				return sections != null && !sections.isEmpty();
			case SadPackage.SAD__TEMPLATE_PATH:
				return TEMPLATE_PATH_EDEFAULT == null ? templatePath != null : !TEMPLATE_PATH_EDEFAULT.equals(templatePath);
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
		result.append(" (templatePath: ");
		result.append(templatePath);
		result.append(')');
		return result.toString();
	}

} //SadImpl
