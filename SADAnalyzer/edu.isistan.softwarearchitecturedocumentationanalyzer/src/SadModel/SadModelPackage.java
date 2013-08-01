/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel;

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
 * @see SadModel.SadModelFactory
 * @model kind="package"
 * @generated
 */
public interface SadModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SadModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.users.exa.unicen.edu.ar/~esolis/sad";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "edu.isistan.softwarearchitecturedocumentanalyzer";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SadModelPackage eINSTANCE = SadModel.impl.SadModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link SadModel.impl.ArtifactImpl <em>Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SadModel.impl.ArtifactImpl
	 * @see SadModel.impl.SadModelPackageImpl#getArtifact()
	 * @generated
	 */
	int ARTIFACT = 2;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ID = 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__TITLE = 1;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__CONTENT = 2;

	/**
	 * The number of structural features of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link SadModel.impl.SadImpl <em>Sad</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SadModel.impl.SadImpl
	 * @see SadModel.impl.SadModelPackageImpl#getSad()
	 * @generated
	 */
	int SAD = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__ID = ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__TITLE = ARTIFACT__TITLE;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__CONTENT = ARTIFACT__CONTENT;

	/**
	 * The feature id for the '<em><b>Sections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD__SECTIONS = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sad</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link SadModel.impl.SadSectionImpl <em>Sad Section</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SadModel.impl.SadSectionImpl
	 * @see SadModel.impl.SadModelPackageImpl#getSadSection()
	 * @generated
	 */
	int SAD_SECTION = 1;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__ID = ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__TITLE = ARTIFACT__TITLE;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__CONTENT = ARTIFACT__CONTENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__NAME = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION__TEXT = ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sad Section</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_SECTION_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link SadModel.Sad <em>Sad</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sad</em>'.
	 * @see SadModel.Sad
	 * @generated
	 */
	EClass getSad();

	/**
	 * Returns the meta object for the reference list '{@link SadModel.Sad#getSections <em>Sections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sections</em>'.
	 * @see SadModel.Sad#getSections()
	 * @see #getSad()
	 * @generated
	 */
	EReference getSad_Sections();

	/**
	 * Returns the meta object for class '{@link SadModel.SadSection <em>Sad Section</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sad Section</em>'.
	 * @see SadModel.SadSection
	 * @generated
	 */
	EClass getSadSection();

	/**
	 * Returns the meta object for the attribute '{@link SadModel.SadSection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see SadModel.SadSection#getName()
	 * @see #getSadSection()
	 * @generated
	 */
	EAttribute getSadSection_Name();

	/**
	 * Returns the meta object for the attribute '{@link SadModel.SadSection#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see SadModel.SadSection#getText()
	 * @see #getSadSection()
	 * @generated
	 */
	EAttribute getSadSection_Text();

	/**
	 * Returns the meta object for class '{@link SadModel.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact</em>'.
	 * @see SadModel.Artifact
	 * @generated
	 */
	EClass getArtifact();

	/**
	 * Returns the meta object for the attribute '{@link SadModel.Artifact#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see SadModel.Artifact#getID()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_ID();

	/**
	 * Returns the meta object for the attribute '{@link SadModel.Artifact#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see SadModel.Artifact#getTitle()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_Title();

	/**
	 * Returns the meta object for the attribute '{@link SadModel.Artifact#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see SadModel.Artifact#getContent()
	 * @see #getArtifact()
	 * @generated
	 */
	EAttribute getArtifact_Content();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SadModelFactory getSadModelFactory();

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
		 * The meta object literal for the '{@link SadModel.impl.SadImpl <em>Sad</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SadModel.impl.SadImpl
		 * @see SadModel.impl.SadModelPackageImpl#getSad()
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
		 * The meta object literal for the '{@link SadModel.impl.SadSectionImpl <em>Sad Section</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SadModel.impl.SadSectionImpl
		 * @see SadModel.impl.SadModelPackageImpl#getSadSection()
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

		/**
		 * The meta object literal for the '{@link SadModel.impl.ArtifactImpl <em>Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SadModel.impl.ArtifactImpl
		 * @see SadModel.impl.SadModelPackageImpl#getArtifact()
		 * @generated
		 */
		EClass ARTIFACT = eINSTANCE.getArtifact();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__ID = eINSTANCE.getArtifact_ID();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__TITLE = eINSTANCE.getArtifact_Title();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTIFACT__CONTENT = eINSTANCE.getArtifact_Content();

	}

} //SadModelPackage
