package com.orbis.web.parser;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.orbis.web.solicitation.FedBizOpSolicitation;

public class WebParser {
	public WebParser() {
		final String etwd = "https://www.fbo.gov/index?s=opportunity&mode=form&id=617194a5d1bd513ab9da0702aa16bf5d&tab=core&tabmode=list";
		final String fboURL  = "https://www.fbo.gov/index?s=opportunity&mode=list&tab=list";
		final String printURL = "https://www.fbo.gov/index?s=opportunity&mode=form&id=617194a5d1bd513ab9da0702aa16bf5d&tab=core&tabmode=list&print_preview=1";
		final String test = "http://www.guildundertow.com/test.php";
		
		Connection searchPage = Jsoup.connect(fboURL);
		searchPage.method(Connection.Method.POST);
		searchPage.data("dnf_class_values[procurement_notice][_posted_date]", "1");
		//searchPage.data("dnf_class_values[procurement_notice][keywords]", "etwd");
		
		// Hidden Attributes required to search
		searchPage.data("dnf_opt_action", "search");
		searchPage.data("so_form_prefix", "dnf_");
		
		
		
		/*
		<input name="so_form_prefix" value="dnf_" type="hidden">
		<input name="dnf_opt_action" value="search" type="hidden">
		<input name="dnf_opt_template" value="vendor_procurement_notice_filter" type="hidden">
		<input name="dnf_opt_mode" value="update" type="hidden">
		<input name="dnf_opt_finalize" value="0" type="hidden">
		<input name="dnf_opt_target" value="" type="hidden">
		<input name="dnf_opt_validate" value="1" type="hidden">
		<input type="hidden" name="dnf_class_values[procurement_notice][dnf_class_name]" value="procurement_notice">
		<input type="hidden" name="clear_filters_from_home" value="1">
		*/
		try {
			//searchPage.execute();
			Document searchResults = searchPage.post();
			
			//Elements e = searchResults.select("#row_0");
			Elements rows = searchResults.select("tr[id~=row_[0-9]+]");
			
			for(Element e : rows) {
				Elements links = e.select("td:eq(0) a");
				String id = links.get(0).attr("href");
				
				System.out.println(id);
				
				FedBizOpSolicitation fbo = new FedBizOpSolicitation("https://www.fbo.gov/" + id + "&print_preview=1");
				fbo.fetchPageContent();
				
				System.out.println(fbo);
				
				//System.out.println(links.text());
			}
			
			
			//System.out.println(rows.text());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Elements body = doc.select("body");
		//Elements body = doc.select("#dnf_class_values_procurement_notice__response_deadline__widget");
		//FedBizOpSolicitation fbo = new FedBizOpSolicitation(printURL);
		//fbo.fetchPageContent();
		
		
		//System.out.println(fbo);
	}

	public static void main(String args[]) {
		new WebParser();
	}
}
