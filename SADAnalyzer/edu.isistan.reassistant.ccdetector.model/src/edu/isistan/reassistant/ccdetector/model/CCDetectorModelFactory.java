/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.reassistant.ccdetector.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.reassistant.ccdetector.model.CCDetectorModelPackage
 * @generated
 */
public interface CCDetectorModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CCDetectorModelFactory eINSTANCE = edu.isistan.reassistant.ccdetector.model.impl.CCDetectorModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Crosscutting Concern Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Crosscutting Concern Rule</em>'.
	 * @generated
	 */
	CrosscuttingConcernRule createCrosscuttingConcernRule();

	/**
	 * Returns a new object of class '<em>Crosscutting Concern Rule Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Crosscutting Concern Rule Set</em>'.
	 * @generated
	 */
	CrosscuttingConcernRuleSet createCrosscuttingConcernRuleSet();

	/**
	 * Returns a new object of class '<em>Query Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query Set</em>'.
	 * @generated
	 */
	QuerySet createQuerySet();

	/**
	 * Returns a new object of class '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query</em>'.
	 * @generated
	 */
	Query createQuery();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CCDetectorModelPackage getCCDetectorModelPackage();

} //CCDetectorModelFactory
