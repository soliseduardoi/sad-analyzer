/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import SadModel.Sad;

import edu.isistan.sadanalyzer.model.CrosscuttingConcern;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;
import edu.isistan.sadanalyzer.model.SadAnalyzerProject;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sad Analyzer Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl#getSad <em>Sad</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl#getSadURI <em>Sad URI</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl#getUimaURI <em>Uima URI</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SadAnalyzerProjectImpl extends IdentifiableImpl implements SadAnalyzerProject {
	/**
	 * The cached value of the '{@link #getSad() <em>Sad</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSad()
	 * @generated
	 * @ordered
	 */
	protected Sad sad;

	/**
	 * The default value of the '{@link #getSadURI() <em>Sad URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSadURI()
	 * @generated
	 * @ordered
	 */
	protected static final String SAD_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSadURI() <em>Sad URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSadURI()
	 * @generated
	 * @ordered
	 */
	protected String sadURI = SAD_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getUimaURI() <em>Uima URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUimaURI()
	 * @generated
	 * @ordered
	 */
	protected static final String UIMA_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUimaURI() <em>Uima URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUimaURI()
	 * @generated
	 * @ordered
	 */
	protected String uimaURI = UIMA_URI_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCrosscuttingConcerns() <em>Crosscutting Concerns</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCrosscuttingConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<CrosscuttingConcern> crosscuttingConcerns;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SadAnalyzerProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SadAnalyzerModelPackage.Literals.SAD_ANALYZER_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sad getSad() {
		if (sad != null && sad.eIsProxy()) {
			InternalEObject oldSad = (InternalEObject)sad;
			sad = (Sad)eResolveProxy(oldSad);
			if (sad != oldSad) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD, oldSad, sad));
			}
		}
		return sad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sad basicGetSad() {
		return sad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSad(Sad newSad) {
		Sad oldSad = sad;
		sad = newSad;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD, oldSad, sad));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSadURI() {
		return sadURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSadURI(String newSadURI) {
		String oldSadURI = sadURI;
		sadURI = newSadURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD_URI, oldSadURI, sadURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUimaURI() {
		return uimaURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUimaURI(String newUimaURI) {
		String oldUimaURI = uimaURI;
		uimaURI = newUimaURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__UIMA_URI, oldUimaURI, uimaURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CrosscuttingConcern> getCrosscuttingConcerns() {
		if (crosscuttingConcerns == null) {
			crosscuttingConcerns = new EObjectResolvingEList<CrosscuttingConcern>(CrosscuttingConcern.class, this, SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS);
		}
		return crosscuttingConcerns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD:
				if (resolve) return getSad();
				return basicGetSad();
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD_URI:
				return getSadURI();
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__UIMA_URI:
				return getUimaURI();
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS:
				return getCrosscuttingConcerns();
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
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD:
				setSad((Sad)newValue);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD_URI:
				setSadURI((String)newValue);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__UIMA_URI:
				setUimaURI((String)newValue);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS:
				getCrosscuttingConcerns().clear();
				getCrosscuttingConcerns().addAll((Collection<? extends CrosscuttingConcern>)newValue);
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
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD:
				setSad((Sad)null);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD_URI:
				setSadURI(SAD_URI_EDEFAULT);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__UIMA_URI:
				setUimaURI(UIMA_URI_EDEFAULT);
				return;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS:
				getCrosscuttingConcerns().clear();
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
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD:
				return sad != null;
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__SAD_URI:
				return SAD_URI_EDEFAULT == null ? sadURI != null : !SAD_URI_EDEFAULT.equals(sadURI);
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__UIMA_URI:
				return UIMA_URI_EDEFAULT == null ? uimaURI != null : !UIMA_URI_EDEFAULT.equals(uimaURI);
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS:
				return crosscuttingConcerns != null && !crosscuttingConcerns.isEmpty();
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
		result.append(" (sadURI: ");
		result.append(sadURI);
		result.append(", uimaURI: ");
		result.append(uimaURI);
		result.append(')');
		return result.toString();
	}

} //SadAnalyzerProjectImpl
