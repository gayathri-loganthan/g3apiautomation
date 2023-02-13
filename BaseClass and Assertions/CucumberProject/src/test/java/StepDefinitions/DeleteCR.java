package StepDefinitions;

import org.testng.annotations.Test;

public class DeleteCR extends baseclass {

	@Test(dependsOnMethods = "StepDefinitions.PatchCR.Patch_CR")
	public void Delete_CR() {
		
		response = inputRequest.delete("/change_request/"+sys_id);
		response.then().assertThat().statusCode(204);
	}
}
