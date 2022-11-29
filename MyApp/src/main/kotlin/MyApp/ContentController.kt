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

fun textProcess(text:String): MutableMap<String, Int>{
    var text = text.lowercase()
    val words= mutableListOf<String>()
    words.addAll(text.split(" "))
    val wordCount = words.size
    val charCountWithSpaces = text.length
    val newText = text.replace(" ", "").replace("\n", "").replace("\r", "").replace(".", "").replace(",","")
    val charCountWoSpaces = newText.length
    val lineCount = text.filter {it == '.'}.count()
    words.clear()
    text = text.replace(".", " ").replace("'s", "").replace(",", "")
    words.addAll(text.split(" "))
    val uniqSet = words.toSet()
    val uniq = uniqSet.size
    return mutableMapOf(
        "word_count" to wordCount,
        "character_count_with_spaces" to charCountWithSpaces,
        "character_count_without_spaces" to charCountWoSpaces,
        "line_count" to lineCount,
        "unique_words" to uniq
    )
}
@Controller("/text/analyze")
class ContentController {

    @Produces(MediaType.APPLICATION_JSON)
    @Post //
    fun textAnalysis(@Body content :JsonObject): HttpResponse<*> {
        var text = content.get("content").stringValue
        val result = textProcess(text)
        return HttpResponse.ok(result)

    }
}