package seedu.address.logic;

import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.StorageManager;

public class TutorialTracingTest {
    @TempDir
    Path temporaryFolder;

    @Test
    public void traceEditCommand() throws Exception {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        StorageManager storage = new StorageManager(
                new JsonAddressBookStorage(temporaryFolder.resolve("addressbook.json")),
                new JsonUserPrefsStorage(temporaryFolder.resolve("prefs.json")));
        new LogicManager(model, storage).execute("edit 1 n/Alice Yeoh");
    }
}
