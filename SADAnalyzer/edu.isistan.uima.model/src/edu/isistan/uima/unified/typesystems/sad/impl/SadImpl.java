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
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl#getKind <em>Kind</em>}</li>
 *   <li>{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl#getName <em>Name</em>}</li>
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
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadPackage.SAD__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadPackage.SAD__KIND, oldKind, kind));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadPackage.SAD__NAME, oldName, name));
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
			case SadPackage.SAD__ID:
				return getId();
			case SadPackage.SAD__KIND:
				return getKind();
			case SadPackage.SAD__NAME:
				return getName();
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
			case SadPackage.SAD__ID:
				setId((String)newValue);
				return;
			case SadPackage.SAD__KIND:
				setKind((String)newValue);
				return;
			case SadPackage.SAD__NAME:
				setName((String)newValue);
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
			case SadPackage.SAD__ID:
				setId(ID_EDEFAULT);
				return;
			case SadPackage.SAD__KIND:
				setKind(KIND_EDEFAULT);
				return;
			case SadPackage.SAD__NAME:
				setName(NAME_EDEFAULT);
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
			case SadPackage.SAD__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SadPackage.SAD__KIND:
				return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
			case SadPackage.SAD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(", id: ");
		result.append(id);
		result.append(", kind: ");
		result.append(kind);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SadImpl
