/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import SadModel.Sad;
import SadModel.SadSection;

import edu.isistan.sadanalyzer.model.CompositionRules;
import edu.isistan.sadanalyzer.model.Impact;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;

import edu.isistan.uima.unified.typesystems.nlp.Sentence;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Impact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl#getRealization <em>Realization</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl#getSection <em>Section</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl#getSad <em>Sad</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl#getSentence <em>Sentence</em>}</li>
 *   <li>{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl#getCompositionRules <em>Composition Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImpactImpl extends IdentifiableImpl implements Impact {
	/**
	 * The default value of the '{@link #getRealization() <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealization()
	 * @generated
	 * @ordered
	 */
	protected static final String REALIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRealization() <em>Realization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealization()
	 * @generated
	 * @ordered
	 */
	protected String realization = REALIZATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSection() <em>Section</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSection()
	 * @generated
	 * @ordered
	 */
	protected SadSection section;

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
	 * The cached value of the '{@link #getSentence() <em>Sentence</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSentence()
	 * @generated
	 * @ordered
	 */
	protected Sentence sentence;

	/**
	 * The default value of the '{@link #getCompositionRules() <em>Composition Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRules()
	 * @generated
	 * @ordered
	 */
	protected static final CompositionRules COMPOSITION_RULES_EDEFAULT = CompositionRules.WRAP;

	/**
	 * The cached value of the '{@link #getCompositionRules() <em>Composition Rules</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositionRules()
	 * @generated
	 * @ordered
	 */
	protected CompositionRules compositionRules = COMPOSITION_RULES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SadAnalyzerModelPackage.Literals.IMPACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRealization() {
		return realization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealization(String newRealization) {
		String oldRealization = realization;
		realization = newRealization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.IMPACT__REALIZATION, oldRealization, realization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadSection getSection() {
		if (section != null && section.eIsProxy()) {
			InternalEObject oldSection = (InternalEObject)section;
			section = (SadSection)eResolveProxy(oldSection);
			if (section != oldSection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SadAnalyzerModelPackage.IMPACT__SECTION, oldSection, section));
			}
		}
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadSection basicGetSection() {
		return section;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSection(SadSection newSection) {
		SadSection oldSection = section;
		section = newSection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.IMPACT__SECTION, oldSection, section));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SadAnalyzerModelPackage.IMPACT__SAD, oldSad, sad));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.IMPACT__SAD, oldSad, sad));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sentence getSentence() {
		if (sentence != null && sentence.eIsProxy()) {
			InternalEObject oldSentence = (InternalEObject)sentence;
			sentence = (Sentence)eResolveProxy(oldSentence);
			if (sentence != oldSentence) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SadAnalyzerModelPackage.IMPACT__SENTENCE, oldSentence, sentence));
			}
		}
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sentence basicGetSentence() {
		return sentence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSentence(Sentence newSentence) {
		Sentence oldSentence = sentence;
		sentence = newSentence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.IMPACT__SENTENCE, oldSentence, sentence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRules getCompositionRules() {
		return compositionRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompositionRules(CompositionRules newCompositionRules) {
		CompositionRules oldCompositionRules = compositionRules;
		compositionRules = newCompositionRules == null ? COMPOSITION_RULES_EDEFAULT : newCompositionRules;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SadAnalyzerModelPackage.IMPACT__COMPOSITION_RULES, oldCompositionRules, compositionRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SadAnalyzerModelPackage.IMPACT__REALIZATION:
				return getRealization();
			case SadAnalyzerModelPackage.IMPACT__SECTION:
				if (resolve) return getSection();
				return basicGetSection();
			case SadAnalyzerModelPackage.IMPACT__SAD:
				if (resolve) return getSad();
				return basicGetSad();
			case SadAnalyzerModelPackage.IMPACT__SENTENCE:
				if (resolve) return getSentence();
				return basicGetSentence();
			case SadAnalyzerModelPackage.IMPACT__COMPOSITION_RULES:
				return getCompositionRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SadAnalyzerModelPackage.IMPACT__REALIZATION:
				setRealization((String)newValue);
				return;
			case SadAnalyzerModelPackage.IMPACT__SECTION:
				setSection((SadSection)newValue);
				return;
			case SadAnalyzerModelPackage.IMPACT__SAD:
				setSad((Sad)newValue);
				return;
			case SadAnalyzerModelPackage.IMPACT__SENTENCE:
				setSentence((Sentence)newValue);
				return;
			case SadAnalyzerModelPackage.IMPACT__COMPOSITION_RULES:
				setCompositionRules((CompositionRules)newValue);
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
			case SadAnalyzerModelPackage.IMPACT__REALIZATION:
				setRealization(REALIZATION_EDEFAULT);
				return;
			case SadAnalyzerModelPackage.IMPACT__SECTION:
				setSection((SadSection)null);
				return;
			case SadAnalyzerModelPackage.IMPACT__SAD:
				setSad((Sad)null);
				return;
			case SadAnalyzerModelPackage.IMPACT__SENTENCE:
				setSentence((Sentence)null);
				return;
			case SadAnalyzerModelPackage.IMPACT__COMPOSITION_RULES:
				setCompositionRules(COMPOSITION_RULES_EDEFAULT);
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
			case SadAnalyzerModelPackage.IMPACT__REALIZATION:
				return REALIZATION_EDEFAULT == null ? realization != null : !REALIZATION_EDEFAULT.equals(realization);
			case SadAnalyzerModelPackage.IMPACT__SECTION:
				return section != null;
			case SadAnalyzerModelPackage.IMPACT__SAD:
				return sad != null;
			case SadAnalyzerModelPackage.IMPACT__SENTENCE:
				return sentence != null;
			case SadAnalyzerModelPackage.IMPACT__COMPOSITION_RULES:
				return compositionRules != COMPOSITION_RULES_EDEFAULT;
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
		result.append(" (Realization: ");
		result.append(realization);
		result.append(", CompositionRules: ");
		result.append(compositionRules);
		result.append(')');
		return result.toString();
	}

} //ImpactImpl
