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
    fun textAnalysis(@Body content:JsonObject): HttpResponse<*> {
        val text = content.get("content").stringValue
        
        val result = mutableMapOf(
            "word_count" to 0,
            "character_count_with_spaces" to 0,
            "character_count_without_spaces" to 0,
            "line_count" to 0,
            "unique_words" to 0
        )

        return HttpResponse.ok(result)

    }
}