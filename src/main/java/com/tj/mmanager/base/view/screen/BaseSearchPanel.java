package com.tj.mmanager.base.view.screen;

import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

/*
 * Para establecer los titulos hay que sobreescribir @getTitlePanel() y @getResultsTitle()
 */
public class BaseSearchPanel extends Panel {

    private static final long serialVersionUID = 8814637617684988536L;

    private VerticalLayout mainLayout;
    private Label titleLabel;
    private GridLayout filtersLayout;
    private HorizontalLayout buttonsLayout;
    private Button searchButton;
    private Button newButton;
    private Button clearButton;
    private Button closeButton;
    private Label resultsLabel;
    private Table resultsTable;

    private static final String DEFAULT_PANEL_TITLE = "BaseSearchPanel";
    private static final String DEFAULT_RESULTS_TITLE = "Results";

    public BaseSearchPanel() {
	mainLayout = buildMainLayout();
    }

    protected VerticalLayout buildMainLayout() {
	VerticalLayout layout = new VerticalLayout();
	titleLabel.setValue(getTitlePanel());
	resultsLabel.setValue(getResultsTitle());
	return layout;
    }

    protected String getTitlePanel() {
	return DEFAULT_PANEL_TITLE;
    }

    protected String getResultsTitle() {
	return DEFAULT_RESULTS_TITLE;
    }

}
