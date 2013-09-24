/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.isistan.sadanalyzer.model.SadAnalyzerModelPackage
 * @generated
 */
public interface SadAnalyzerModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SadAnalyzerModelFactory eINSTANCE = edu.isistan.sadanalyzer.model.impl.SadAnalyzerModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sad Analyzer Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sad Analyzer Project</em>'.
	 * @generated
	 */
	SadAnalyzerProject createSadAnalyzerProject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SadAnalyzerModelPackage getSadAnalyzerModelPackage();

} //SadAnalyzerModelFactory
