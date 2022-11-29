package MyApp

import com.fasterxml.jackson.databind.util.JSONPObject
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Body
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.json.tree.JsonObject


@Controller("/text/analyze")
class ContentController {

    @Produces(MediaType.APPLICATION_JSON)
    @Post //
    fun textAnalysis(@Body content :JsonObject): HttpResponse<*> {
        var text = content.get("content").stringValue
        text = text.lowercase()
        val words: List<String> = text.split(" ")
        val wordCount = words.size
        val charCountWithSpaces = text.length
        val newText = text.replace(" ", "").replace("\n", "").replace("\r", "")
        val charCountWoSpaces = newText.length
        val lineCount = text.filter {it == '.'}.count()
        val uniqSet = words.toSet()
        val uniq = uniqSet.size
        val result = mutableMapOf(
            "word_count" to wordCount,
            "character_count_with_spaces" to charCountWithSpaces,
            "character_count_without_spaces" to charCountWoSpaces,
            "line_count" to lineCount,
            "unique_words" to uniq
        )

        return HttpResponse.ok(result)

    }
}