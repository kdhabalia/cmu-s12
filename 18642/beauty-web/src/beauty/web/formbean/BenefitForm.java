package beauty.web.formbean;

import java.util.ArrayList;

import beauty.web.model.Benefit;
import beauty.web.util.StringUtil;

public class BenefitForm extends BaseForm {

	private String name;

	public void populateBenefit(Benefit be) {
		be.setName(name);
		be.setStdForm(StringUtil.getStdFrom(name));
	}

	public ArrayList<String> getValidationErrors() {
		ArrayList<String> errors = new ArrayList<String>();

		errors.addAll(super.getValidationErrors());

		if (!this.isGet()) {
			if (name == null || name.length() == 0) {
				errors.add("name is null");
			}
		}
		return errors;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = StringUtil.sanitize(name);
	}
}
