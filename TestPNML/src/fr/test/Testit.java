package fr.test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

import fr.lip6.move.pnml.framework.general.PnmlImport;
import fr.lip6.move.pnml.framework.hlapi.HLAPIRootClass;
import fr.lip6.move.pnml.framework.utils.ModelRepository;
import fr.lip6.move.pnml.framework.utils.exception.InvalidIDException;
import fr.lip6.move.pnml.symmetricnet.hlcorestructure.hlapi.PetriNetDocHLAPI;


public class Testit {

	public static void main(String[] args) {
		URI uri = new File(args[0]).toURI(); 
		long debut = System.currentTimeMillis();
		final PnmlImport pim = new PnmlImport();
		try {
			ModelRepository.getInstance().createDocumentWorkspace(uri.getPath());
		} catch (final InvalidIDException e1) {
			e1.printStackTrace();
		}

		pim.setFallUse(true);
		HLAPIRootClass imported ;
		try {
			imported = (HLAPIRootClass) pim.importFile(uri.getPath());
			Logger.getLogger("Tester").info("Load time of PNML (colored model parsed with PNMLFW) : " + (System.currentTimeMillis() - debut) + " ms"); //$NON-NLS-1$ //$NON-NLS-2$

			final PetriNetDocHLAPI root = (PetriNetDocHLAPI) imported;

			assert(root.getNets().size()==1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
