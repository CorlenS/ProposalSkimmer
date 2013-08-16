package com.orbis.web.solicitation;

import java.util.Hashtable;

public class FedBizOpSolicitation extends AbstractSolicitation {

	public FedBizOpSolicitation(String url) {
		super(url);
	}

	@Override
	protected Hashtable<String, String> initializeFields() {
		Hashtable<String, String> fields = new Hashtable<String, String>();

		fields.put(ID_TITLE, ".agency-header > h2");
		fields.put(ID_SOLICITATION_NUMBER, ".agency-header > .sol-num ");
		fields.put(ID_AGENCY, ".agency-header > .agency-name");
		//fields.put(ID_OFFICE, "");
		//fields.put(ID_LOCATION, "");
		fields.put(ID_NOTICE_TYPE, "#dnf_class_values_procurement_notice__procurement_type__widget");
		fields.put(ID_ORIGINAL_POST_DATE, "#dnf_class_values_procurement_notice__original_posted_date__widget");
		fields.put(ID_POSTED_DATE, "#dnf_class_values_procurement_notice__posted_date__widget");
		fields.put(ID_RESPONSE_DATE, "#dnf_class_values_procurement_notice__response_deadline__widget");
		fields.put(ID_ORIGINAL_RESPONSE_DATE, "#dnf_class_values_procurement_notice__original_response_deadline__widget");
		fields.put(ID_ARCHIVING_POLICY, "#dnf_class_values_procurement_notice__archive_type__widget");
		fields.put(ID_ORIGINAL_ARCHIVE_DATE, "#dnf_class_values_procurement_notice__original_archive_date__widget");
		fields.put(ID_ARCHIVE_DATE, "#dnf_class_values_procurement_notice__archive_date__widget");
		fields.put(ID_ORIGINAL_SET_ASIDE, "#dnf_class_values_procurement_notice__original_set_aside__widget");
		fields.put(ID_SET_ASIDE, "#dnf_class_values_procurement_notice__set_aside__widget");
		fields.put(ID_CLASSIFICATION_CODE, "#dnf_class_values_procurement_notice__classification_code__widget");
		fields.put(ID_NAICS_CODE, "#dnf_class_values_procurement_notice__naics_code__widget");
		fields.put(ID_SYNOPSIS, "#dnf_class_values_procurement_notice__description__widget");
		//fields.put(ID_LINKS_LIST, "");
		fields.put(ID_CONTRACTING_OFFICE_ADDRESS, "#dnf_class_values_procurement_notice__office_address_text__widget");
		fields.put(ID_PLACE_OF_PERFORMANCE, "#dnf_class_values_procurement_notice__place_of_performance__widget");
		fields.put(ID_PRIMARY_CONTACT, "#dnf_class_values_procurement_notice__primary_poc__widget");
		fields.put(ID_SECONDARY_CONTACT, "#dnf_class_values_procurement_notice__secondary_poc__widget");
		//fields.put(ID_FILES_LIST, "");
		//fields.put(ID_HISTORY, "");

		return fields;
	}

}
