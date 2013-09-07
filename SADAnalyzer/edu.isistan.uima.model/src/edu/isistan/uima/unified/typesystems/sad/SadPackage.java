/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.uima.unified.typesystems.sad;

import edu.isistan.uima.unified.typesystems.TypesystemsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.isistan.uima.unified.typesystems.sad.SadFactory
 * @model kind="package"
 * @generated
 */
public interface SadPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sad";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///edu/isistan/uima/unified/typesystems/sad.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sad";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SadPackage eINSTANCE = edu.isistan.uima.unified.typesystems.sad.impl.SadPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl <em>Sad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadImpl
	 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadPackageImpl#getSad()
	 * @generated
	 */
	int SAD = 0;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__SECTIONS = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__TEMPLATE_PATH = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.isistan.uima.unified.typesystems.sad.impl.SadSectionImpl <em>Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadSectionImpl
	 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadPackageImpl#getSadSection()
	 * @generated
	 */
	int SAD_SECTION = 1;

	/**
	 * The feature id for the '<em><b>Sofa</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__SOFA = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__SOFA;

	/**
	 * The feature id for the '<em><b>Begin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__BEGIN = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__BEGIN;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__END = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__END;

	/**
	 * The feature id for the '<em><b>Identification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__IDENTIFICATION = TypesystemsPackage.IDENTIFIABLE_ANNOTATION__IDENTIFICATION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__NAME = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__TEXT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION_FEATURE_COUNT = TypesystemsPackage.IDENTIFIABLE_ANNOTATION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.sad.Sad <em>Sad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sad</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.Sad
	 * @generated
	 */
	EClass getSad();

	/**
	 * Returns the meta object for the reference list '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sections</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.Sad#getSections()
	 * @see #getSad()
	 * @generated
	 */
	EReference getSad_Sections();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.sad.Sad#getTemplatePath <em>Template Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template Path</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.Sad#getTemplatePath()
	 * @see #getSad()
	 * @generated
	 */
	EAttribute getSad_TemplatePath();

	/**
	 * Returns the meta object for class '{@link edu.isistan.uima.unified.typesystems.sad.SadSection <em>Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Section</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.SadSection
	 * @generated
	 */
	EClass getSadSection();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.sad.SadSection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.SadSection#getName()
	 * @see #getSadSection()
	 * @generated
	 */
	EAttribute getSadSection_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.isistan.uima.unified.typesystems.sad.SadSection#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see edu.isistan.uima.unified.typesystems.sad.SadSection#getText()
	 * @see #getSadSection()
	 * @generated
	 */
	EAttribute getSadSection_Text();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SadFactory getSadFactory();

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
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.sad.impl.SadImpl <em>Sad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadImpl
		 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadPackageImpl#getSad()
		 * @generated
		 */
		EClass SAD = eINSTANCE.getSad();

		/**
		 * The meta object literal for the '<em><b>Sections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAD__SECTIONS = eINSTANCE.getSad_Sections();

		/**
		 * The meta object literal for the '<em><b>Template Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAD__TEMPLATE_PATH = eINSTANCE.getSad_TemplatePath();

		/**
		 * The meta object literal for the '{@link edu.isistan.uima.unified.typesystems.sad.impl.SadSectionImpl <em>Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadSectionImpl
		 * @see edu.isistan.uima.unified.typesystems.sad.impl.SadPackageImpl#getSadSection()
		 * @generated
		 */
		EClass SAD_SECTION = eINSTANCE.getSadSection();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAD_SECTION__NAME = eINSTANCE.getSadSection_Name();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAD_SECTION__TEXT = eINSTANCE.getSadSection_Text();

	}

} //SadPackage
