/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel.impl;

import SadModel.*;

import org.eclipse.emf.ecore.EClass;
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
public class SadModelFactoryImpl extends EFactoryImpl implements SadModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SadModelFactory init() {
		try {
			SadModelFactory theSadModelFactory = (SadModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~esolis/sad"); 
			if (theSadModelFactory != null) {
				return theSadModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SadModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadModelFactoryImpl() {
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
			case SadModelPackage.SAD: return createSad();
			case SadModelPackage.SAD_SECTION: return createSadSection();
			case SadModelPackage.ARTIFACT: return createArtifact();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sad createSad() {
		SadImpl sad = new SadImpl();
		return sad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadSection createSadSection() {
		SadSectionImpl sadSection = new SadSectionImpl();
		return sadSection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Artifact createArtifact() {
		ArtifactImpl artifact = new ArtifactImpl();
		return artifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadModelPackage getSadModelPackage() {
		return (SadModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SadModelPackage getPackage() {
		return SadModelPackage.eINSTANCE;
	}

} //SadModelFactoryImpl
