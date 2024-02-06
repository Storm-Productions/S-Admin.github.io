import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.ext.footnotes.FootnoteExtension;
import com.vladsch.flexmark.ext.front.matter.YamlFrontMatterExtension;
import com.vladsch.flexmark.ext.gitlab.GitLabExtension;
import com.vladsch.flexmark.ext.ins.InsExtension;
import com.vladsch.flexmark.ext.superscript.SuperscriptExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.typographic.TypographicExtension;
import com.vladsch.flexmark.ext.emoji.EmojiExtension;
import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterBlock;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.util.Arrays;

public class MarkdownToHtml {
    public static void main(String[] args) {
        String markdown = "# Admin Panel Documentation\n" +
                "\n" +
                "Welcome to the Admin Panel documentation! This guide will walk you through the various features and functionalities available in the Admin Panel.\n" +
                "\n" +
                "## Overview\n" +
                "\n" +
                "The Admin Panel serves as the central hub for managing your application. From user management to system configurations, everything you need is conveniently organized and accessible.\n" +
                "\n" +
                "## Quick Links\n" +
                "\n" +
                "- [User Management](#user-management)\n" +
                "- [Content Moderation](#content-moderation)\n" +
                "- [System Settings](#system-settings)\n" +
                "- [Analytics](#analytics)\n" +
                "\n" +
                "## User Management\n" +
                "\n" +
                "The User Management section allows you to manage users, roles, and permissions efficiently. With a range of actions available, you can keep your user base organized and secure.\n" +
                "\n" +
                "### Actions:\n" +
                "- **Create New User:** Add new users to the system.\n" +
                "- **Edit User Details:** Modify user profiles and information.\n" +
                "- **Assign Roles and Permissions:** Control access levels by assigning roles and permissions.\n" +
                "- **Deactivate or Delete Users:** Manage user accounts as needed.\n" +
                "\n" +
                "## Content Moderation\n" +
                "\n" +
                "Ensure the quality and appropriateness of content on your platform with the Content Moderation tools. Review, edit, or remove content to maintain community standards.\n" +
                "\n" +
                "### Actions:\n" +
                "- **Review Pending Content:** Monitor and approve pending content submissions.\n" +
                "- **Edit or Remove Content:** Modify or delete existing content as necessary.\n" +
                "- **Apply Filters and Restrictions:** Set up filters and restrictions to prevent inappropriate content.\n" +
                "\n" +
                "## System Settings\n" +
                "\n" +
                "Customize and configure various aspects of your system to meet your specific requirements.\n" +
                "\n" +
                "### Actions:\n" +
                "- **General Settings:** Configure basic system settings such as language, timezone, etc.\n" +
                "- **Security Settings:** Manage security-related configurations like password policies, authentication methods, etc.\n" +
                "- **Email Settings:** Set up email notifications and templates.\n" +
                "- **Integration Settings:** Integrate with other services or platforms.\n" +
                "\n" +
                "## Analytics\n" +
                "\n" +
                "Gain insights into user behavior, system performance, and more with powerful analytics tools.\n" +
                "\n" +
                "### Actions:\n" +
                "- **View Reports:** Access detailed reports on user activity, content performance, etc.\n" +
                "- **Generate Custom Reports:** Create custom reports tailored to your specific needs.\n" +
                "- **Export Data:** Export analytics data for further analysis or sharing.\n" +
                "\n" +
                "---\n" +
                "\n" +
                "Thank you for using our Admin Panel documentation. If you have any questions or need further assistance, feel free to reach out to our support team.";

        MutableDataSet options = new MutableDataSet();
        options.set(Parser.EXTENSIONS, Arrays.asList(
                TablesExtension.create(),
                AutolinkExtension.create(),
                StrikethroughExtension.create(),
                AbbreviationExtension.create(),
                DefinitionExtension.create(),
                FootnoteExtension.create(),
                YamlFrontMatterExtension.create(),
                GitLabExtension.create(),
                InsExtension.create(),
                SuperscriptExtension.create(),
                TablesExtension.create(),
                TypographicExtension.create(),
                EmojiExtension.create(),
                WikiLinkExtension.create()
        ));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // Parse Markdown to HTML
        Node document = parser.parse(markdown);
        String html = renderer.render(document);

        // Apply black background
        html = "<html><head><style>body { background-color: black; color: white; }</style></head><body>" + html + "</body></html>";

        System.out.println(html);
    }
}
