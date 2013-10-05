/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelFactory
 * @model kind="package"
 * @generated
 */
public interface SadAnalyzerModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.users.exa.unicen.edu.ar/~esolis/sadanalyzer";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.isistan.sadanalyzer.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SadAnalyzerModelPackage eINSTANCE = edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.impl.IdentifiableImpl
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.impl.NameableImpl <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.impl.NameableImpl
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 1;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl <em>Sad Analyzer Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getSadAnalyzerProject()
	 * @generated
	 */
	int SAD_ANALYZER_PROJECT = 2;

	/**
	 * The feature id for the '<em><b>Sad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT__SAD = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sad URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT__SAD_URI = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uima URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT__UIMA_URI = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Crosscutting Concerns</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sad Analyzer Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getCrosscuttingConcern()
	 * @generated
	 */
	int CROSSCUTTING_CONCERN = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Impacts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__IMPACTS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sads</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN__SADS = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Crosscutting Concern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CROSSCUTTING_CONCERN_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl <em>Impact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.impl.ImpactImpl
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getImpact()
	 * @generated
	 */
	int IMPACT = 4;

	/**
	 * The feature id for the '<em><b>Realization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__REALIZATION = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Section</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__SECTION = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sad</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__SAD = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sentence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__SENTENCE = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Composition Rules</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT__COMPOSITION_RULES = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Impact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link edu.isistan.sadanalyzer.model.CompositionRules <em>Composition Rules</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.sadanalyzer.model.CompositionRules
	 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getCompositionRules()
	 * @generated
	 */
	int COMPOSITION_RULES = 5;


	/**
	 * Returns the meta object for class '{@link edu.isistan.sadanalyzer.model.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see edu.isistan.sadanalyzer.model.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for class '{@link edu.isistan.sadanalyzer.model.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see edu.isistan.sadanalyzer.model.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for class '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject <em>Sad Analyzer Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sad Analyzer Project</em>'.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerProject
	 * @generated
	 */
	EClass getSadAnalyzerProject();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSad <em>Sad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sad</em>'.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSad()
	 * @see #getSadAnalyzerProject()
	 * @generated
	 */
	EReference getSadAnalyzerProject_Sad();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSadURI <em>Sad URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sad URI</em>'.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerProject#getSadURI()
	 * @see #getSadAnalyzerProject()
	 * @generated
	 */
	EAttribute getSadAnalyzerProject_SadURI();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getUimaURI <em>Uima URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uima URI</em>'.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerProject#getUimaURI()
	 * @see #getSadAnalyzerProject()
	 * @generated
	 */
	EAttribute getSadAnalyzerProject_UimaURI();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.sadanalyzer.model.SadAnalyzerProject#getCrosscuttingConcerns <em>Crosscutting Concerns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Crosscutting Concerns</em>'.
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerProject#getCrosscuttingConcerns()
	 * @see #getSadAnalyzerProject()
	 * @generated
	 */
	EReference getSadAnalyzerProject_CrosscuttingConcerns();

	/**
	 * Returns the meta object for class '{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern <em>Crosscutting Concern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Crosscutting Concern</em>'.
	 * @see edu.isistan.sadanalyzer.model.CrosscuttingConcern
	 * @generated
	 */
	EClass getCrosscuttingConcern();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.isistan.sadanalyzer.model.CrosscuttingConcern#getDescription()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EAttribute getCrosscuttingConcern_Description();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getImpacts <em>Impacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Impacts</em>'.
	 * @see edu.isistan.sadanalyzer.model.CrosscuttingConcern#getImpacts()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Impacts();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.sadanalyzer.model.CrosscuttingConcern#getSads <em>Sads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sads</em>'.
	 * @see edu.isistan.sadanalyzer.model.CrosscuttingConcern#getSads()
	 * @see #getCrosscuttingConcern()
	 * @generated
	 */
	EReference getCrosscuttingConcern_Sads();

	/**
	 * Returns the meta object for class '{@link edu.isistan.sadanalyzer.model.Impact <em>Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact
	 * @generated
	 */
	EClass getImpact();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.sadanalyzer.model.Impact#getRealization <em>Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Realization</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact#getRealization()
	 * @see #getImpact()
	 * @generated
	 */
	EAttribute getImpact_Realization();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.sadanalyzer.model.Impact#getSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Section</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact#getSection()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Section();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.sadanalyzer.model.Impact#getSad <em>Sad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sad</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact#getSad()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Sad();

	/**
	 * Returns the meta object for the reference '{@link edu.isistan.sadanalyzer.model.Impact#getSentence <em>Sentence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sentence</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact#getSentence()
	 * @see #getImpact()
	 * @generated
	 */
	EReference getImpact_Sentence();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.sadanalyzer.model.Impact#getCompositionRules <em>Composition Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Composition Rules</em>'.
	 * @see edu.isistan.sadanalyzer.model.Impact#getCompositionRules()
	 * @see #getImpact()
	 * @generated
	 */
	EAttribute getImpact_CompositionRules();

	/**
	 * Returns the meta object for enum '{@link edu.isistan.sadanalyzer.model.CompositionRules <em>Composition Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Composition Rules</em>'.
	 * @see edu.isistan.sadanalyzer.model.CompositionRules
	 * @generated
	 */
	EEnum getCompositionRules();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SadAnalyzerModelFactory getSadAnalyzerModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.impl.IdentifiableImpl
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.impl.NameableImpl <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.impl.NameableImpl
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl <em>Sad Analyzer Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerProjectImpl
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getSadAnalyzerProject()
		 * @generated
		 */
		EClass SAD_ANALYZER_PROJECT = eINSTANCE.getSadAnalyzerProject();

		/**
		 * The meta object literal for the '<em><b>Sad</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAD_ANALYZER_PROJECT__SAD = eINSTANCE.getSadAnalyzerProject_Sad();

		/**
		 * The meta object literal for the '<em><b>Sad URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAD_ANALYZER_PROJECT__SAD_URI = eINSTANCE.getSadAnalyzerProject_SadURI();

		/**
		 * The meta object literal for the '<em><b>Uima URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAD_ANALYZER_PROJECT__UIMA_URI = eINSTANCE.getSadAnalyzerProject_UimaURI();

		/**
		 * The meta object literal for the '<em><b>Crosscutting Concerns</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS = eINSTANCE.getSadAnalyzerProject_CrosscuttingConcerns();

		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl <em>Crosscutting Concern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.impl.CrosscuttingConcernImpl
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getCrosscuttingConcern()
		 * @generated
		 */
		EClass CROSSCUTTING_CONCERN = eINSTANCE.getCrosscuttingConcern();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CROSSCUTTING_CONCERN__DESCRIPTION = eINSTANCE.getCrosscuttingConcern_Description();

		/**
		 * The meta object literal for the '<em><b>Impacts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__IMPACTS = eINSTANCE.getCrosscuttingConcern_Impacts();

		/**
		 * The meta object literal for the '<em><b>Sads</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CROSSCUTTING_CONCERN__SADS = eINSTANCE.getCrosscuttingConcern_Sads();

		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.impl.ImpactImpl <em>Impact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.impl.ImpactImpl
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getImpact()
		 * @generated
		 */
		EClass IMPACT = eINSTANCE.getImpact();

		/**
		 * The meta object literal for the '<em><b>Realization</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT__REALIZATION = eINSTANCE.getImpact_Realization();

		/**
		 * The meta object literal for the '<em><b>Section</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__SECTION = eINSTANCE.getImpact_Section();

		/**
		 * The meta object literal for the '<em><b>Sad</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__SAD = eINSTANCE.getImpact_Sad();

		/**
		 * The meta object literal for the '<em><b>Sentence</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT__SENTENCE = eINSTANCE.getImpact_Sentence();

		/**
		 * The meta object literal for the '<em><b>Composition Rules</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPACT__COMPOSITION_RULES = eINSTANCE.getImpact_CompositionRules();

		/**
		 * The meta object literal for the '{@link edu.isistan.sadanalyzer.model.CompositionRules <em>Composition Rules</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.sadanalyzer.model.CompositionRules
		 * @see edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelPackageImpl#getCompositionRules()
		 * @generated
		 */
		EEnum COMPOSITION_RULES = eINSTANCE.getCompositionRules();

	}

} //SadAnalyzerModelPackage
