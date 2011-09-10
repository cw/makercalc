class MsgAppender extends Backbone.View
  initialize: ->
    console.log "woo InitialView"

  adapt_callback: (i, width) ->
    msg = "i: #{i}, width: #{width}<br/>"
    $("#content").append(msg)
