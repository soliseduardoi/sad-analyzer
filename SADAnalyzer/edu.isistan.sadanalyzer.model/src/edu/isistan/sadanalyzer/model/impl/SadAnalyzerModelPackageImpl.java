/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import SadModel.SadModelPackage;

import edu.isistan.sadanalyzer.model.CompositionRules;
import edu.isistan.sadanalyzer.model.CrosscuttingConcern;
import edu.isistan.sadanalyzer.model.Identifiable;
import edu.isistan.sadanalyzer.model.Impact;
import edu.isistan.sadanalyzer.model.Nameable;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelFactory;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;
import edu.isistan.sadanalyzer.model.SadAnalyzerProject;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;
import edu.isistan.uima.unified.typesystems.nlp.NLPPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import uima.cas.CasPackage;
import uima.tcas.TCasPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SadAnalyzerModelPackageImpl extends EPackageImpl implements SadAnalyzerModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sadAnalyzerProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass crosscuttingConcernEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum compositionRulesEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SadAnalyzerModelPackageImpl() {
		super(eNS_URI, SadAnalyzerModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SadAnalyzerModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SadAnalyzerModelPackage init() {
		if (isInited) return (SadAnalyzerModelPackage)EPackage.Registry.INSTANCE.getEPackage(SadAnalyzerModelPackage.eNS_URI);

		// Obtain or create and register package
		SadAnalyzerModelPackageImpl theSadAnalyzerModelPackage = (SadAnalyzerModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SadAnalyzerModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SadAnalyzerModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SadModelPackage.eINSTANCE.eClass();
		TypesystemsPackage.eINSTANCE.eClass();
		CasPackage.eINSTANCE.eClass();
		TCasPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSadAnalyzerModelPackage.createPackageContents();

		// Initialize created meta-data
		theSadAnalyzerModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSadAnalyzerModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SadAnalyzerModelPackage.eNS_URI, theSadAnalyzerModelPackage);
		return theSadAnalyzerModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSadAnalyzerProject() {
		return sadAnalyzerProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSadAnalyzerProject_Sad() {
		return (EReference)sadAnalyzerProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSadAnalyzerProject_SadURI() {
		return (EAttribute)sadAnalyzerProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSadAnalyzerProject_UimaURI() {
		return (EAttribute)sadAnalyzerProjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSadAnalyzerProject_CrosscuttingConcerns() {
		return (EReference)sadAnalyzerProjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCrosscuttingConcern() {
		return crosscuttingConcernEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcern_Description() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcern_Impacts() {
		return (EReference)crosscuttingConcernEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCrosscuttingConcern_Sads() {
		return (EReference)crosscuttingConcernEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCrosscuttingConcern_Name() {
		return (EAttribute)crosscuttingConcernEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpact() {
		return impactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpact_Realization() {
		return (EAttribute)impactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Section() {
		return (EReference)impactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Sad() {
		return (EReference)impactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpact_Sentence() {
		return (EReference)impactEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpact_CompositionRules() {
		return (EAttribute)impactEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCompositionRules() {
		return compositionRulesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerModelFactory getSadAnalyzerModelFactory() {
		return (SadAnalyzerModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		identifiableEClass = createEClass(IDENTIFIABLE);

		nameableEClass = createEClass(NAMEABLE);

		sadAnalyzerProjectEClass = createEClass(SAD_ANALYZER_PROJECT);
		createEReference(sadAnalyzerProjectEClass, SAD_ANALYZER_PROJECT__SAD);
		createEAttribute(sadAnalyzerProjectEClass, SAD_ANALYZER_PROJECT__SAD_URI);
		createEAttribute(sadAnalyzerProjectEClass, SAD_ANALYZER_PROJECT__UIMA_URI);
		createEReference(sadAnalyzerProjectEClass, SAD_ANALYZER_PROJECT__CROSSCUTTING_CONCERNS);

		crosscuttingConcernEClass = createEClass(CROSSCUTTING_CONCERN);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__DESCRIPTION);
		createEReference(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__IMPACTS);
		createEReference(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__SADS);
		createEAttribute(crosscuttingConcernEClass, CROSSCUTTING_CONCERN__NAME);

		impactEClass = createEClass(IMPACT);
		createEAttribute(impactEClass, IMPACT__REALIZATION);
		createEReference(impactEClass, IMPACT__SECTION);
		createEReference(impactEClass, IMPACT__SAD);
		createEReference(impactEClass, IMPACT__SENTENCE);
		createEAttribute(impactEClass, IMPACT__COMPOSITION_RULES);

		// Create enums
		compositionRulesEEnum = createEEnum(COMPOSITION_RULES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SadModelPackage theSadModelPackage = (SadModelPackage)EPackage.Registry.INSTANCE.getEPackage(SadModelPackage.eNS_URI);
		NLPPackage theNLPPackage = (NLPPackage)EPackage.Registry.INSTANCE.getEPackage(NLPPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sadAnalyzerProjectEClass.getESuperTypes().add(this.getIdentifiable());
		sadAnalyzerProjectEClass.getESuperTypes().add(this.getNameable());
		crosscuttingConcernEClass.getESuperTypes().add(this.getIdentifiable());
		crosscuttingConcernEClass.getESuperTypes().add(this.getNameable());
		impactEClass.getESuperTypes().add(this.getIdentifiable());

		// Initialize classes and features; add operations and parameters
		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sadAnalyzerProjectEClass, SadAnalyzerProject.class, "SadAnalyzerProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSadAnalyzerProject_Sad(), theSadModelPackage.getSad(), null, "sad", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSadAnalyzerProject_SadURI(), ecorePackage.getEString(), "sadURI", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSadAnalyzerProject_UimaURI(), ecorePackage.getEString(), "uimaURI", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSadAnalyzerProject_CrosscuttingConcerns(), this.getCrosscuttingConcern(), null, "CrosscuttingConcerns", null, 0, -1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(crosscuttingConcernEClass, CrosscuttingConcern.class, "CrosscuttingConcern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCrosscuttingConcern_Description(), ecorePackage.getEString(), "Description", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcern_Impacts(), this.getImpact(), null, "Impacts", null, 0, -1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCrosscuttingConcern_Sads(), theSadModelPackage.getSad(), null, "sads", null, 0, -1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCrosscuttingConcern_Name(), ecorePackage.getEString(), "name", null, 0, 1, CrosscuttingConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactEClass, Impact.class, "Impact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImpact_Realization(), ecorePackage.getEString(), "Realization", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Section(), theSadModelPackage.getSadSection(), null, "section", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Sad(), theSadModelPackage.getSad(), null, "sad", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpact_Sentence(), theNLPPackage.getSentence(), null, "sentence", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpact_CompositionRules(), this.getCompositionRules(), "CompositionRules", null, 0, 1, Impact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(compositionRulesEEnum, CompositionRules.class, "CompositionRules");
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.WRAP);
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.OVERLAP);
		addEEnumLiteral(compositionRulesEEnum, CompositionRules.OVERRIDE);

		// Create resource
		createResource(eNS_URI);
	}

} //SadAnalyzerModelPackageImpl
