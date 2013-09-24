/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import SadModel.SadModelPackage;

import edu.isistan.sadanalyzer.model.Identifiable;
import edu.isistan.sadanalyzer.model.Nameable;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelFactory;
import edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage;
import edu.isistan.sadanalyzer.model.SadAnalyzerProject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sadAnalyzerProjectEClass.getESuperTypes().add(this.getIdentifiable());
		sadAnalyzerProjectEClass.getESuperTypes().add(this.getNameable());

		// Initialize classes and features; add operations and parameters
		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sadAnalyzerProjectEClass, SadAnalyzerProject.class, "SadAnalyzerProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSadAnalyzerProject_Sad(), theSadModelPackage.getSad(), null, "sad", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSadAnalyzerProject_SadURI(), ecorePackage.getEString(), "sadURI", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSadAnalyzerProject_UimaURI(), ecorePackage.getEString(), "uimaURI", null, 0, 1, SadAnalyzerProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SadAnalyzerModelPackageImpl
