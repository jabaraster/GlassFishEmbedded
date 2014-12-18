/**
 * 
 */
package info.jabara.sandbox.web.ui;

import info.jabara.sandbox.entity.EEmployee;
import info.jabara.sandbox.service.HogeService;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 * @author jabaraster
 */
public class HomePage extends WebPage {
    private static final long   serialVersionUID = -1017140620750071969L;

    @Inject
    HogeService                 hogeService;

    private FeedbackPanel       Feedback;
    private Link<?>             link;
    private ListView<EEmployee> Employees;

    /**
     * 
     */
    public HomePage() {
        this.add(new Label("now", new AbstractReadOnlyModel<String>() { //$NON-NLS-1$
                    private static final long serialVersionUID = -3398916675376073052L;

                    @Override
                    public String getObject() {
                        return HomePage.this.hogeService.getNow();
                    }
                }));
        this.add(getFeedback());
        this.add(getLink());
        this.add(getEmployees());
    }

    @SuppressWarnings("synthetic-access")
    private ListView<EEmployee> getEmployees() {
        if (this.Employees == null) {
            this.Employees = new ListView<EEmployee>("employees", new A()) { //$NON-NLS-1$
                private static final long serialVersionUID = 3158546979877767324L;

                @Override
                protected void populateItem(final ListItem<EEmployee> pItem) {
                    pItem.add(new Label("id", String.valueOf(pItem.getModelObject().getId()))); //$NON-NLS-1$
                    pItem.add(new Label("name", pItem.getModelObject().getName())); //$NON-NLS-1$
                }
            };
        }
        return this.Employees;
    }

    private FeedbackPanel getFeedback() {
        if (this.Feedback == null) {
            this.Feedback = new FeedbackPanel("feedback"); //$NON-NLS-1$
        }
        return this.Feedback;
    }

    private Link<?> getLink() {
        if (this.link == null) {
            this.link = new Link<Object>("link") { //$NON-NLS-1$
                private static final long serialVersionUID = -5788350638821016723L;

                @Override
                public void onClick() {
                    try {
                        HomePage.this.hogeService.insert();
                    } catch (final Exception e) {
                        error(e);
                    }
                }
            };
        }
        return this.link;
    }

    private class A extends LoadableDetachableModel<List<EEmployee>> {
        private static final long serialVersionUID = 8743714600299730392L;

        @Override
        protected List<EEmployee> load() {
            return HomePage.this.hogeService.getAll();
        }
    }
}
