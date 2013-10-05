/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import edu.isistan.sadanalyzer.model.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SadAnalyzerModelFactoryImpl extends EFactoryImpl implements SadAnalyzerModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SadAnalyzerModelFactory init() {
		try {
			SadAnalyzerModelFactory theSadAnalyzerModelFactory = (SadAnalyzerModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~esolis/sadanalyzer"); 
			if (theSadAnalyzerModelFactory != null) {
				return theSadAnalyzerModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SadAnalyzerModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT: return createSadAnalyzerProject();
			case SadAnalyzerModelPackage.CROSSCUTTING_CONCERN: return createCrosscuttingConcern();
			case SadAnalyzerModelPackage.IMPACT: return createImpact();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SadAnalyzerModelPackage.COMPOSITION_RULES:
				return createCompositionRulesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SadAnalyzerModelPackage.COMPOSITION_RULES:
				return convertCompositionRulesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerProject createSadAnalyzerProject() {
		SadAnalyzerProjectImpl sadAnalyzerProject = new SadAnalyzerProjectImpl();
		return sadAnalyzerProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CrosscuttingConcern createCrosscuttingConcern() {
		CrosscuttingConcernImpl crosscuttingConcern = new CrosscuttingConcernImpl();
		return crosscuttingConcern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Impact createImpact() {
		ImpactImpl impact = new ImpactImpl();
		return impact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositionRules createCompositionRulesFromString(EDataType eDataType, String initialValue) {
		CompositionRules result = CompositionRules.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCompositionRulesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerModelPackage getSadAnalyzerModelPackage() {
		return (SadAnalyzerModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SadAnalyzerModelPackage getPackage() {
		return SadAnalyzerModelPackage.eINSTANCE;
	}

} //SadAnalyzerModelFactoryImpl
