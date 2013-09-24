/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.isistan.sadanalyzer.model.impl;

import edu.isistan.sadanalyzer.model.*;

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
public class SadAnalyzerModelFactoryImpl extends EFactoryImpl implements SadAnalyzerModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SadAnalyzerModelFactory init() {
		try {
			SadAnalyzerModelFactory theSadAnalyzerModelFactory = (SadAnalyzerModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.users.exa.unicen.edu.ar/~esolis/sadanalyzer"); 
			if (theSadAnalyzerModelFactory != null) {
				return theSadAnalyzerModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SadAnalyzerModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerModelFactoryImpl() {
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
			case SadAnalyzerModelPackage.SAD_ANALYZER_PROJECT: return createSadAnalyzerProject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerProject createSadAnalyzerProject() {
		SadAnalyzerProjectImpl sadAnalyzerProject = new SadAnalyzerProjectImpl();
		return sadAnalyzerProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadAnalyzerModelPackage getSadAnalyzerModelPackage() {
		return (SadAnalyzerModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SadAnalyzerModelPackage getPackage() {
		return SadAnalyzerModelPackage.eINSTANCE;
	}

} //SadAnalyzerModelFactoryImpl
