/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see SadModel.SadModelPackage
 * @generated
 */
public interface SadModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SadModelFactory eINSTANCE = SadModel.impl.SadModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sad</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sad</em>'.
	 * @generated
	 */
	Sad createSad();

	/**
	 * Returns a new object of class '<em>Sad Section</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sad Section</em>'.
	 * @generated
	 */
	SadSection createSadSection();

	/**
	 * Returns a new object of class '<em>Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Artifact</em>'.
	 * @generated
	 */
	Artifact createArtifact();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SadModelPackage getSadModelPackage();

} //SadModelFactory
