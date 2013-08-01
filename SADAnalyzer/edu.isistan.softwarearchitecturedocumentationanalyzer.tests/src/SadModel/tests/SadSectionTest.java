/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel.tests;

import SadModel.SadModelFactory;
import SadModel.SadSection;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sad Section</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SadSectionTest extends ArtifactTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SadSectionTest.class);
	}

	/**
	 * Constructs a new Sad Section test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadSectionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sad Section test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SadSection getFixture() {
		return (SadSection)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SadModelFactory.eINSTANCE.createSadSection());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //SadSectionTest
