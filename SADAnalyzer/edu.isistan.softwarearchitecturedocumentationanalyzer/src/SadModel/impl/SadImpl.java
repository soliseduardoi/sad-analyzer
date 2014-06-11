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
 *   <li>{@link SadModel.impl.SadImpl#getSections <em>Sections</em>}</li>
 *   <li>{@link SadModel.impl.SadImpl#getTemplatePath <em>Template Path</em>}</li>
 *   <li>{@link SadModel.impl.SadImpl#getLocale <em>Locale</em>}</li>
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
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected String locale = LOCALE_EDEFAULT;

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
			eNotify(new ENotificationImpl(this, Notification.SET, SadModelPackage.SAD__TEMPLATE_PATH, oldTemplatePath, templatePath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocale(String newLocale) {
		String oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadModelPackage.SAD__LOCALE, oldLocale, locale));
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
			case SadModelPackage.SAD__TEMPLATE_PATH:
				return getTemplatePath();
			case SadModelPackage.SAD__LOCALE:
				return getLocale();
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
			case SadModelPackage.SAD__TEMPLATE_PATH:
				setTemplatePath((String)newValue);
				return;
			case SadModelPackage.SAD__LOCALE:
				setLocale((String)newValue);
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
			case SadModelPackage.SAD__TEMPLATE_PATH:
				setTemplatePath(TEMPLATE_PATH_EDEFAULT);
				return;
			case SadModelPackage.SAD__LOCALE:
				setLocale(LOCALE_EDEFAULT);
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
			case SadModelPackage.SAD__TEMPLATE_PATH:
				return TEMPLATE_PATH_EDEFAULT == null ? templatePath != null : !TEMPLATE_PATH_EDEFAULT.equals(templatePath);
			case SadModelPackage.SAD__LOCALE:
				return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
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
		result.append(", locale: ");
		result.append(locale);
		result.append(')');
		return result.toString();
	}

} //SadImpl
