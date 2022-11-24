Feature: Get File Metadata
  Background: User authorized

  Scenario Outline: User can have ability to get metadata of existing file
    Given I want to get metadata of file by existing path "<filepath>"
    When I send POST request to "https://api.dropboxapi.com/2/sharing/get_file_metadata"

    Examples:
    | filepath                        |
    | /photos/first.png  |
    | /photos/second.png |