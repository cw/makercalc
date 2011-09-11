class MsgAppender extends Backbone.View
  initialize: ->
    console.log "woo InitialView"
    window.wave = @wave
    $("body").delegate "#content", "click", (evt) ->
      # Call android device specific code if demo object exists
      window.demo?.clickOnAndroid()

  wave: ->
    alert "Alert"

  adapt_callback: (i, width) ->
    msg = "i: #{i}, width: #{width}<br/>"
    $("#content").append(msg)
