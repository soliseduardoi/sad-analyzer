/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SadModel.tests;

import SadModel.Sad;
import SadModel.SadModelFactory;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sad</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SadTest extends ArtifactTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SadTest.class);
	}

	/**
	 * Constructs a new Sad test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SadTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sad test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Sad getFixture() {
		return (Sad)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SadModelFactory.eINSTANCE.createSad());
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

} //SadTest
