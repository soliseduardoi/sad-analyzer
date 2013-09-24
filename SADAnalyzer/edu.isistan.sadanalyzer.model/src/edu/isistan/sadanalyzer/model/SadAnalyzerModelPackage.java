/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

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
	 * The number of structural features of the '<em>Sad Analyzer Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAD_ANALYZER_PROJECT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;


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

	}

} //SadAnalyzerModelPackage
